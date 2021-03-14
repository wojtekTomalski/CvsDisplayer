package com.example.my_app.services;

import com.example.my_app.models.Match;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@org.springframework.stereotype.Service
public class Service {

    private  List<Match> matches = new ArrayList<>();

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public List<Match> getMatches() throws MalformedURLException{
        URL url = new URL("https://raw.githubusercontent.com/footballcsv/england/master/2020s/2020-21/eng.1.csv");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase();

        try(CSVParser csvParser = CSVParser.parse(url, StandardCharsets.UTF_8, csvFormat)) {
            for(CSVRecord csvRecord : csvParser) {
                String round = csvRecord.get(0);
                String date = csvRecord.get(1);
                String team1 = csvRecord.get(2);
                String ft = csvRecord.get(3);
                String team2 = csvRecord.get(4);
                Match match = new Match(round,date,team1,ft,team2);
                matches.add(match);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matches;
    }

}


