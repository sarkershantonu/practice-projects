package org.automation.github;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.BooleanOptionHandler;

import java.io.IOException;


public class Client {
    private static final String DEFAULT_GITHUB_HOST = "www.github.com";//or your corporate client

    private static final int ERROR_BAD_OPTIONS = -1;
    private static final int ERROR_IO_EXCEPTION = -2;

    @Option(name = "--host", metaVar = "<github_hostname>", usage = "The GitHub host to connect to\nDefaults to " + DEFAULT_GITHUB_HOST)
    private String hostname = DEFAULT_GITHUB_HOST;

    @Option(name = "--user", metaVar = "<username>", usage = "GitHub username")
    private String username;

    @Option(name = "--pass", metaVar = "<password>", usage = "GitHub Password")
    private String password;

    @Option(name = "--help", aliases = {"-h"}, handler = BooleanOptionHandler.class, usage = "help")
    private boolean showUsage = false;

    public void run(String[] args) {
        final CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println("Failed to parse command line arguments.");
            usageExit();
        }


        if (args == null || args.length == 0 || showUsage) {
            usageExit();
        }

        DisableSSLCertificationValidation.apply();

        GitHubClient client = new GitHubClient(hostname);


        if (username == null) {
            username = UserInput.getStringOption("user");
        }
        if (password == null) {
            password = UserInput.getStringOption("pass");
        }
        client.setCredentials(username, password);

        RepositoryService service = new RepositoryService(client);
        try {
            for (Repository repo : service.getRepositories("AutomationUI")) {
                System.out.println(repo.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(ERROR_IO_EXCEPTION);
        }

    }


    private void usageExit() {
        System.err.println("ERROR : Connecting to a GitHub server and show repositories");
        new CmdLineParser(this).printUsage(System.err);
        System.exit(ERROR_BAD_OPTIONS);
    }


}
