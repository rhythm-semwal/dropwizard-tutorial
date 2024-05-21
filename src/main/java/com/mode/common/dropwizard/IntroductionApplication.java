package com.mode.common.dropwizard;

import java.util.List;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import java.util.ArrayList;


public class IntroductionApplication extends Application<BasicConfiguration> {

    //The main method is responsible for running the application. We could either pass the args
    // to the run method or fill it by ourselves
    //The first argument can be either server or check. The check option validates the configuration, while the server option runs the application. The second argument is the location of the configuration file.

    public static void main(String[] args) throws Exception {
        new IntroductionApplication().run("server", "introduction-config.yml");
    }


    // The run method allows us to access both the Environment and the BaseConfiguration
    @Override
    public void run(BasicConfiguration basicConfiguration, Environment environment) {
        int defaultSize = basicConfiguration.getDefaultSize();
        BrandRepository brandRepository = new BrandRepository(initBrands());
        BrandResource brandResource = new BrandResource(defaultSize, brandRepository);

        environment
                .jersey()
                .register(brandResource);
    }

    private List<Brand> initBrands() {
        List<Brand> brands = new ArrayList<>();
        brands.add(new Brand(1L, "Brand A"));
        brands.add(new Brand(2L, "Brand B"));

        return brands;
    }

    @Override
    public void initialize(Bootstrap<BasicConfiguration> bootstrap) {
        // Set the configuration source provider to load configuration from resources.
        // the application to find a given configuration file in the resource directory.
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
        // Additional initialization if needed
    }
}
