/**
 * Author by Jordan Vincent
 * Universitas Sanata Dharma
 *
 * Nilai R yang diminta, disesuaikan untuk masing2 soal
 * */
package permutation;

import java.util.*;

public class ShowAllNode {
    private LinkedList<Node> hosts;            //Anggota (n)
    private Set<LinkedList<Node>> history;     //Menyimpan gabungan yang pernah dibuat
    private LinkedList<Node> current;          //Set yang sedang dibentuk
    private Map<String, Boolean> hold;

    /**
     * Constructor
     */
    public ShowAllNode(LinkedList<Node> hosts) {
        this.hosts = new LinkedList<>();
        this.history = new HashSet<>();
        this.current = new LinkedList<>();
        this.hosts.addAll(hosts);
    }

    public void addHosts(Node host) {
        this.hosts.add(host);
    }

    /**
     * Recursive
     * @param hosts --> for expected group of host
     */
    private void recAllNode(Node host, LinkedList<Node> hosts) {
        if (!this.hold.get(host.getLabel())) {
            this.hold.put(host.getLabel(), true);
            this.current.add(host);

            //masih belum memiliki kombinasi set tersebut di history
            if (!this.history.contains(this.current)) {
                this.history.add(new LinkedList<>(this.current));

                if (this.current.size() != this.hosts.size()) {
                    for (Node nextHost : hosts) {
                        this.recAllNode(nextHost, hosts);
                    }
                }
            }

            this.hold.put(host.getLabel(), false);
            this.current.removeLast();
        }
    }

    /**
     * Recursive untuk merge list
     *
     * Logika-nya mirip dengan yang atas
     */
    private void recList(String key, Map<String, Set<LinkedList<Node>>> hostGroups) {
        if (!this.hold.get(key)) {
            this.hold.put(key, true);

            Iterator<LinkedList<Node>> iterator = hostGroups.get(key).iterator();
            while (iterator.hasNext()) {
                LinkedList<Node> nextList = iterator.next();
                this.current.addAll(nextList);

                if (!this.history.contains(this.current)) {
                    this.history.add(new LinkedList<>(this.current));

                    for (String nextKey : hostGroups.keySet()) {
                        this.recList(nextKey, hostGroups);
                    }
                }
                this.current.removeAll(nextList);
            }
            this.hold.put(key, false);
        }
    }

    /**
     * Result ambil dari history saja
     *
     * For merge using .addAll()
     * then put the result into history
     *
     */
    private void mergeResults (Map<String, Set<LinkedList<Node>>> hostGroups) {
        this.resetHold(this.setToList(hostGroups));
        for (Object key : hostGroups.keySet()) {
            recList((String) key, hostGroups);
        }
    }

    private LinkedList<Node> setToList(Map<String, Set<LinkedList<Node>>> hostGroups) {
        LinkedList<Node> result = new LinkedList<>();
        for (Object key : hostGroups.keySet()) {
            Node node = new Node((String) key);
            result.add(node);
        }
        return result;
    }

    private Set<LinkedList<Node>> getFromHistory(int size) {
        Set<LinkedList<Node>> result = new HashSet<>();
        for (LinkedList<Node> history : this.history) {
            if (history.size() == size) {
                result.add(history);
            }
        }
        return result;
    }

    private Map<String, LinkedList<Node>> splitHostGroup() {
        Map<String, LinkedList<Node>> result = new HashMap<>();

        for(Node host : this.hosts) {
            String first = Character.toString(this.detectFirstChar(host.getLabel()));

            if (result.get(first) == null) {
                LinkedList<Node> group = new LinkedList<>();
                group.add(host);
                result.put(first, group);
            } else {
                LinkedList<Node> group = result.get(first);
                group.add(host);
                result.put(first, group);
            }
        }

        return result;
    }

    private char detectFirstChar(String input) {
        return input.charAt(0);
    }

    //Untuk soal A
    public void startARec() {
        this.hold = new HashMap<>();
        this.resetHold(this.hosts);

        for (Node host : this.hosts) {
            this.recAllNode(host, this.hosts);
        }

        this.output(this.hosts.size());
    }

    public void startDRec(Map<String, Integer> feature) {
        int count = 0;
        this.hold = new HashMap<>();
        Map<String, Set<LinkedList<Node>>> fromHist = new HashMap<>();
        Map<String, LinkedList<Node>> split = this.splitHostGroup();

        for (Object key : split.keySet()) {
            LinkedList<Node> group = split.get(key);
            this.resetHold(group);

            for (Node host : group) {
                this.recAllNode(host, group);
            }

            if (feature == null) {
                fromHist.put(key.toString(), this.getFromHistory(group.size()));
                this.hold.clear();
                this.history.clear();
            } else {
                System.out.println(key.toString());
                int size = feature.get(key.toString());
                fromHist.put(key.toString(), this.getFromHistory(size));
                count += size;
                this.hold.clear();
                this.history.clear();
            }
        }

        this.mergeResults(fromHist);
        this.output(count);
    }

    //Sepertinya tidak butuh di reset, tinggal di clear, dan tunggu di isi lagi saja
    private void resetHold(LinkedList<Node> groupHost) {
        for (Node host : groupHost) {
            this.hold.put(host.getLabel(), false);
        }
    }

    private void output(int size) {
        int counter = 0;
        for (LinkedList<Node> history : this.history) {
            if (history.size() == size) {
                List<String> result = new ArrayList<>();
                for (Node node : history) {
                    result.add(node.getLabel());
                }
                System.out.println(++counter + "-->" + result);
            }
        }
    }
}
