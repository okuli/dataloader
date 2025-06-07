package com.example.dgs.config;

import com.example.dgs.compat.DataLoaderOptionsCompat;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderOptions;
import org.dataloader.DataLoaderRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataLoaderConfig {

    @Bean
    public DataLoaderRegistry dataLoaderRegistry() {
        DataLoaderRegistry registry = new DataLoaderRegistry();

        var batchLoader = (keys, env) ->
                java.util.concurrent.CompletableFuture.supplyAsync(() -> keys);

        DataLoaderOptions opts = DataLoaderOptionsCompat.newOptions()
                .setBatchLoaderContextProvider(() -> null)
                .build();

        DataLoader<String, String> loader =
                DataLoader.newDataLoader(batchLoader, opts);

        registry.register("echoLoader", loader);
        return registry;
    }
}