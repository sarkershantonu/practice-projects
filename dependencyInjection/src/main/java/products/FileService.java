package products;

/**
 * Created by shantonu on 6/16/16.
 */
public class FileService implements Service {
    @Override
    public String serve() {
        return "this gives text file as service";
    }
}
