package bd.hellofood.back.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import bd.hellofood.back.FirebaseCallback;
import bd.hellofood.back.beans.OrderBean;
import bd.hellofood.back.beans.PlaceBean;

@Service
public class FirebaseRealtimeService {

	PlaceBean place;
	boolean dataFetched;

	public PlaceBean getPlace(String area) throws InterruptedException {
		
		dataFetched = false;

		DatabaseReference ref = FirebaseDatabase.getInstance().getReference("placeName/" + area);

		// get only once
		ref.addListenerForSingleValueEvent(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				// TODO Auto-generated method stub

				place = snapshot.getValue(PlaceBean.class);			
				dataFetched = true;

				System.out.println("printing place: " + place.toString());

			}

			@Override
			public void onCancelled(DatabaseError error) {
				// TODO Auto-generated method stub
				System.out.println("The read failed: " + error.getCode());

			}
		});
		
		//wait for onDatachange to populate place
		while(!dataFetched){
			
		}

		return place;

	}

}
