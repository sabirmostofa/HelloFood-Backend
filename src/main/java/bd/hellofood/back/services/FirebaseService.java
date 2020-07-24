package bd.hellofood.back.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.firebase.cloud.FirestoreClient;

import bd.hellofood.back.beans.OrderBean;

@Service
public class FirebaseService {

    public List<OrderBean> getOrders() throws InterruptedException, ExecutionException {

        Iterable<CollectionReference> collectionReferences = FirestoreClient.getFirestore().listCollections();
        List<QueryDocumentSnapshot> documents = new ArrayList<>();

        for (CollectionReference collectionReference : collectionReferences) {
            documents.addAll(collectionReference.get().get().getDocuments());
        }

        return documents.stream().map(queryDocumentSnapshot -> queryDocumentSnapshot.toObject(OrderBean.class))
                .collect(Collectors.toList());
    }

    public List<OrderBean> getOrdersByArea(String areaName) throws InterruptedException, ExecutionException {

        List<QueryDocumentSnapshot> orders = FirestoreClient.getFirestore()
                .collection(areaName)
                .get()
                .get()
                .getDocuments();

        return orders.stream()
                .map(queryDocumentSnapshot -> {
                    OrderBean orderBean = queryDocumentSnapshot.toObject(OrderBean.class);
                    orderBean.setId(queryDocumentSnapshot.getId());
                    return orderBean;
                }).collect(Collectors.toList());
    }
}
