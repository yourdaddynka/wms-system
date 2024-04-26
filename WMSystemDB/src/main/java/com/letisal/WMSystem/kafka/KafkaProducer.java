package com.letisal.WMSystem.kafka;

import com.letisal.WMSystem.models.Document;
import com.letisal.WMSystem.models.Product;
import com.letisal.WMSystem.models.Provider;
import com.letisal.WMSystem.models.StockGeo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {
    @NonNull
    private final KafkaTemplate<String, String> kafkaTemplate;
    @NonNull private final KafkaTemplate<String, Document> kafkaTemplateDocument;
    @NonNull private final KafkaTemplate<String, Product> kafkaTemplateProduct;
    @NonNull private final KafkaTemplate<String, Provider> kafkaTemplateProvider;

    public void sendMessageProduct(Product product) {kafkaTemplateProduct.send("dbProduct", product);}
    public void sendMessageDocument(Document document) {kafkaTemplateDocument.send("dbDocument", document);}
    public void sendMessageProvider(Provider provider) {kafkaTemplateProvider.send("dbProvider", provider);}

}
