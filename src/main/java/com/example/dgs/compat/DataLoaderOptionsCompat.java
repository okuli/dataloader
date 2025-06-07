package com.example.dgs.compat;

import org.dataloader.BatchLoaderContextProvider;
import org.dataloader.DataLoaderOptions;
import org.dataloader.BatchLoaderEnvironment;

import java.util.function.Supplier;

public class DataLoaderOptionsCompat {
    private final DataLoaderOptions options;

    private DataLoaderOptionsCompat(DataLoaderOptions options) {
        this.options = options;
    }

    public static DataLoaderOptionsCompat newOptions() {
        return new DataLoaderOptionsCompat(DataLoaderOptions.newOptions());
    }

    public DataLoaderOptionsCompat setBatchLoaderContextProvider(
            Supplier<BatchLoaderEnvironment> provider) {
        options.setBatchLoaderContextProvider((BatchLoaderContextProvider) provider);
        return this;
    }

    public DataLoaderOptions build() {
        return options;
    }
}