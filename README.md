# Algorithmic Aspects of Telecommunication Networks Project

## Author

1. Sangeetha Pradeep (SPX210004)


## Project Structure

```
aatn-project1
    |__ driver
        |__ NetworkDesignApp.java
    |__ network-design
        |__ data
            |__ OptimalNetwork.java
            |__ ShortestPathData.java
        |__ util
            |__ Pair.java
        |__ Network.java
        |__ OpticalNetworkDesign.java
        |__ ShortestPath.java
    |__ network-param-generator
        |__ generator
            |__ CostGenerator.java
            |__ TrafficDEmandGenerator.java
        |__ utils
            |__ RandomUtils.java
    |__ network-visulizeer
        |__ GraphVisualizer.java
    |__ README.md
```

## Run Commands

```
sh
cd  /path-to/aatn-project1/network-design
mkdir build
javac -sourcepath src -d build src/*.java
cd  /path-to/aatn-project1/network-param-generator
mkdir build
javac -sourcepath src -d build src/*.java
cd  /path-to/aatn-project1/network-visulaizer
mkdir build
javac -sourcepath src -d build src/*.java
cd  /path-to/aatn-project1/driver
mkdir build
javac -sourcepath src -d build src/*.java
java -cp build NetworkDesignApp
```
