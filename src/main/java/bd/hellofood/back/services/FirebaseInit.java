package bd.hellofood.back.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import bd.hellofood.back.FirebaseConfig;

@Service
public class FirebaseInit {

    @Autowired
    private FirebaseConfig firebaseConfig;

    @PostConstruct
    public void init() throws IOException {

		boolean hasBeenInitialized = false;
		List<FirebaseApp> firebaseApps = FirebaseApp.getApps();

        FileInputStream serviceAccount =
                new FileInputStream(firebaseConfig.getAccountInfo());

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl(firebaseConfig.getDbUrl())
                .build();

        for (FirebaseApp app : firebaseApps) {
            if (app.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                hasBeenInitialized = true;
            }
        }

        if (!hasBeenInitialized) {
            FirebaseApp.initializeApp(options);
        }
    }
}
