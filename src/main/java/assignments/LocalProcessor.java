package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String name;
    private long cycle;
    protected String version;
    private int cost;
    private Scanner informationScanner;
    private LinkedList<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(String name, long cycle, String version, int cost, Scanner informationScanner, LinkedList<String> stringArrayList) {
        this.name = name;
        this.cycle = cycle;
        this.version = version;
        this.cost = cost;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (int i = 0; i < cycle; i++) {
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(LinkedList<String> stringList) {
        String processorName = "";
        for (int i = 0; i < stringArrayList.size(); i++) {
            processorName += stringList.get(i) + " ";
        }
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        while (informationScanner.hasNext()) {
            version += informationScanner.nextLine();
        }
    }
}
