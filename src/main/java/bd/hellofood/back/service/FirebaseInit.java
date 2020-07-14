package bd.hellofood.back.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseInit {
	
	@PostConstruct
	public void init() throws IOException {
	
	FileInputStream serviceAccount =
			  new FileInputStream("./firebase-sdk.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
			  .setDatabaseUrl("https://hellofood-2019.firebaseio.com")
			  .build();
			
			
			boolean hasBeenInitialized=false;
			List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
			for(FirebaseApp app : firebaseApps){
			    if(app.getName().equals(FirebaseApp.DEFAULT_APP_NAME)){
			        hasBeenInitialized=true;
			       
			    }
			}

			if(!hasBeenInitialized) {
			    FirebaseApp.initializeApp( options);
			}
			
		
	}

}
