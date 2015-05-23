import java.util.ArrayList;

public class BuildMan {
 static ArrayList<buildNumPair> buildList = new ArrayList<buildNumPair>();
 
 public static incompleteBuild getBuild(int givenBuildNum){
  for(int i=0;i<buildList.size();i++){
   if(buildList.get(i).buildNum==givenBuildNum){
    return buildList.get(i).build;
   }
  }
  
  return null;
 }

public static int getMax() {
	return buildList.get(buildList.size()).buildNum;
}
}

class buildNumPair{
 int buildNum;
 incompleteBuild build;
 public buildNumPair(int buildNm, incompleteBuild b){
	 buildNum = buildNm;
	 build = b;
 }
}