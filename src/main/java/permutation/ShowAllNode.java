/**
 * Author by Jordan Vincent
 * Universitas Sanata Dharma
 * */
package permutation;

import java.util.*;

public class ShowAllNode {
    private LinkedList<Node> hosts;            //Anggota (n)
    private Set<LinkedList<Node>> history;     //Menyimpan gabungan yang pernah dibuat
    private LinkedList<Node> current;          //Set yang sedang dibentuk
    private Map<Node, Boolean> hold;
    private int size;                               //Jumlah yang diminta (r)

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
    public ShowAllNode(LinkedList<Node> hosts, int size) {
        this(size);
        this.hosts.addAll(hosts);
    }

    public void addHosts(Node host) {
        this.hosts.add(host);
    }

    //Recursive
    public void recAllNode(Node host) {
        if (!this.hold.get(host)) {
            this.hold.put(host, true);
            this.current.add(host);

            //masih belum memiliki kombinasi set tersebut di history
            if (!this.history.contains(this.current)) {
                this.history.add(new LinkedList<>(this.current));

                if (this.current.size() != this.size) {
                    for (Node nextHost : this.hosts) {
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

        for (Node host : this.hosts) {
            this.recAllNode(host);
        }

        this.output();
    }

    public void resetHold() {
        for (Node host : this.hosts) {
            this.hold.put(host, false);
        }
    }

    public void output() {
        int counter = 0;
        for (LinkedList<Node> history : this.history) {
            if (history.size() == this.size) {
                List<String> result = new ArrayList<>();
                for (Node node : history) {
                    result.add(node.getLabel());
                }
                System.out.println(++counter + "-->" + result);
            }
        }
    }
}
