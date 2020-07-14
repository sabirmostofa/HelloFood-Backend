package bd.hellofood.back.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

import bd.hellofood.back.beans.OrderBean;

@Service
public class FirebaseService {
	public List getOrders() throws InterruptedException, ExecutionException {
		
		Firestore db =  FirestoreClient.getFirestore();
		
		ApiFuture<QuerySnapshot> ref = db.collection("Jamalpur").get();
		
		
	    QuerySnapshot querySnapshot = ref.get();
	    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
	    
	    
	    List<OrderBean> docs = new ArrayList<OrderBean>();
	    for (QueryDocumentSnapshot document : documents) {
	    	  System.out.println(document.getId() + " => "  );
	    	  OrderBean singleOrder = document.toObject(OrderBean.class);
	    	  docs.add(singleOrder);
	    	  System.out.println(singleOrder.toString());
	    	}
		return docs;
	}

}
