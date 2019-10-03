package ru.levchenko.service.storage;



import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "C:\\JAVA\\SelfProjectMarketPlaceSpringMVC\\src\\main\\webapp\\files";



}
