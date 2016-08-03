package org.automation.dal.encrypted;

import com.healthmarketscience.jackcess.CryptCodecProvider;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import net.ucanaccess.jdbc.JackcessOpenerInterface;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by shantonu on 8/4/16.
 */
public class FileOpenerByCrypto implements JackcessOpenerInterface {
    @Override
    public Database open(File mdbFile, String password) throws IOException {
        DatabaseBuilder builder = new DatabaseBuilder();
        builder.setFile(mdbFile);
        builder.setAutoSync(false);
        builder.setReadOnly(false);
        builder.setCodecProvider(new CryptCodecProvider());
        return null;
    }
}
