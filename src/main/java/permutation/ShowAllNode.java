package permutation;

import java.util.*;

public class ShowAllNode {
//    private LinkedList<Node> nodes;
    private LinkedList<Character> hosts;            //Anggota (n)
    private Set<LinkedList<Character>> history;     //Menyimpan gabungan yang pernah dibuat
    private LinkedList<Character> current;          //Set yang sedang dibentuk
    private Map<Character, Boolean> hold;
    private int size;   //Jumlah yang diminta (r)

    /**
     * Constructor
     */
    public ShowAllNode(int size) {
        this.hosts = new LinkedList<>();
        this.history = new HashSet<>();
        this.current = new LinkedList<>();

        this.size = size;
    }

    /**
     * Constructor
     */
    public ShowAllNode(LinkedList<Character> hosts, int size) {
        this(size);
        this.hosts.addAll(hosts);
    }

    public void addHosts(char Character) {
        this.hosts.add(Character);
    }

    //Recursive
    public void recAllNode(char host) {
        if (!this.hold.get(host)) {
            this.hold.put(host, true);
            this.current.add(host);

            //masih belum memiliki kombinasi set tersebut di history
            if (!this.history.contains(this.current)) {
                this.history.add(new LinkedList<>(this.current));

                if (this.current.size() != this.size) {
                    for (char nextHost : this.hosts) {
                        this.recAllNode(nextHost);
                    }
                }
            }

            this.hold.put(host, false);
            this.current.removeLast();
        }
    }

    public void startRec() {
        this.hold = new HashMap<>();
        this.resetHold();

        for (char host : this.hosts) {
            this.recAllNode(host);
        }

        this.output();
    }

    public void resetHold() {
        for (char host : this.hosts) {
            this.hold.put(host, false);
        }
    }

    public void output() {
        int counter = 0;
        for (LinkedList<Character> history : this.history) {
            if (history.size() == this.size) {
                System.out.println(++counter + "-->" + history);
            }
        }
    }
}
