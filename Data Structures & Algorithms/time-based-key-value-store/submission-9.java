class TimeMap {

    TreeMap<String, String> timeMap;

    public TimeMap() {
        this.timeMap = new TreeMap<>((a, b) -> {
            String[] keyA = a.split("#");
            String[] keyB = b.split("#");
            int numA = Integer.parseInt(keyA[1]);
            int numB = Integer.parseInt(keyB[1]);

            if(keyA[0].equals(keyB[0])) {
                return Integer.compare(numA, numB);
            }

            return keyA[0].compareTo(keyB[0]);

        });
    }
    
    public void set(String key, String value, int timestamp) {
        String finalKey = key + "#" + String.valueOf(timestamp);
        timeMap.put(finalKey, value);
    }
    
    public String get(String key, int timestamp) {
        String finalKey = key + "#" +String.valueOf(timestamp);
        String resultKey = timeMap.floorKey(finalKey);
        if(resultKey == null) {
            return "";
        }

        String resultOgKey = resultKey.split("#")[0];
        if(!resultOgKey.equals(key)) {
            return "";
        }
        return timeMap.get(resultKey);
    }
}
