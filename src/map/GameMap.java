package map;

import main.*;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

import game.GameSession;

/*
 * GameMap.java
 * Assignment: Final Project 2018-19 (Game: Survivability 3)
 * Purpose: Show what you learned in the APCS class (e.g. inheritance, interfaces, ArrayLists, etc.)
 * @version 6/24/2019
 ----------------------------------------------------------------------------------------------------
 */

public class GameMap {
	
	// The string constant to where the maps are stored!
	public static final String MAP_FOLDER = Main.REL_PATH_TO_FILES+"maps";
	
	// Width and Length in meters
	private int width, length;
	
	// THe name of the map to be displayed!
	private String category, name;
	
	// Save for later if there is enough time
	private HashMap componentMap, entityMap, partMap;
	
	// The chunks of the map. Constructed based on the width and height!
	private Chunk[][] chunks;
	
	// The list of all the entities in the map!
	private ArrayList<Entity> entities;
	
	// Constructs a GameMap based on category, name, width and length!
	public GameMap(String category, String name, int width, int length){
		this(category+"\\"+name, width, length);
		this.category = category;
		this.name = name;
	}
	
	// Constructs a GameMap based on width and length!
	public GameMap(String name, int width, int length){
	    		
		// Field assigners
		this.name = name;
		this.width = width;
		this.length = length;
		
		// Constructs and initializes objects involved!
		File file = new File(MAP_FOLDER+"\\"+name+"\\map.dat");
		
		componentMap = new HashMap<String, ChunkComponent>();
		entityMap = new HashMap<String, Entity>();
		partMap = new HashMap<String, Part>();
		
		chunks = new Chunk[width][length];
	    	
		// Fills the 2D array of chunks with constructed Chunk objects!
		for(int i = 0; i < chunks.length; i++){
			for(int j = 0; j < chunks[i].length; j++){
				chunks[i][j] = new Chunk();
			}
		}
		
		// Constructs the ArrayList of entities!
		entities = new ArrayList<Entity>();
		
		// Scans the file to put into the 2D array of chunks!
		scanMapAndPutIntoChunks(file);
		
	}
	
	// Scans the file to put into the 2D array of chunks!
	private void scanMapAndPutIntoChunks(File file){
		// Variables for Part
		Image i = null;
		BufferedImage image = null;
		int orient;
		int x, y, dx, dy, dz;
		
		int totalTokens = countTokens(file);
      
		int countedTokens = 0;
		
		try {
			Scanner s = new Scanner(file);
	         
			int chunkX = 0;
			int chunkY = 0;
			int chunkZ = 0;
	         
			Chunk c = null;
         
			// Variables for Part
	         
			while(s.hasNext()){

				String token = s.next();
	            	
				if(token.equals("chunk")){
	               
					chunkX = s.nextInt();
					chunkZ = s.nextInt();
					countedTokens+=3;
					System.out.println("Loading Map "+name+": "+countedTokens+"/"+totalTokens
									   +" Complete!");
				} else if(token.equals("component")){
					chunkY = s.nextInt();
					countedTokens+=2;
					System.out.println("Loading Map "+name+": "+countedTokens+"/"+totalTokens
									   +" Complete!");
				} else if(token.equals("entity")){
					int entityX = s.nextInt();
					int entityY = s.nextInt();
					int entityZ = s.nextInt();
					countedTokens+=4;
					System.out.println("Loading Map "+name+": "+countedTokens+"/"+totalTokens
									   +" Complete!");
				} else {
					
					// Constructs and sets up HashMap for orientation of Part.
					
					c = chunks[chunkX][chunkZ];
					
					HashMap<String, Integer> orientMap = new HashMap<String, Integer>();
					orientMap.put("up", 0);
					orientMap.put("down", 1);
					orientMap.put("north", 2);
					orientMap.put("south", 3);
					orientMap.put("east", 4);
					orientMap.put("west", 5);
					
					String part = token;
               
					// Handle component part of chunk
	               
					part = part.replace("[","").replace("]","");
	               
					String[] params = part.split(",");
					
					orient = orientMap.get(params[1]);
	               
					x = Integer.parseInt(params[2]);
					y = Integer.parseInt(params[3]);
					dx = Integer.parseInt(params[4]);
					dy = Integer.parseInt(params[5]);
					dz = Integer.parseInt(params[6]);
					
					i = ImageIO.read(new File(MAP_FOLDER+"\\"+name+"\\images\\"+params[0]+".jpg"))
						.getScaledInstance(dx, dy, Image.SCALE_SMOOTH);
	            
					image = new BufferedImage(dx, dy, BufferedImage.TYPE_INT_ARGB);
					
					Graphics2D g2d = image.createGraphics();
					g2d.drawImage(i, 0, 0, null);
					g2d.dispose();
					
					ChunkPart chunkPart = new ChunkPart(image, orient, x, y, dx, dy, dz
														, chunkX, chunkY, chunkZ);
					
					c.addPart(chunkPart, chunkY);
					countedTokens++;
					System.out.println("Loading Map "+name+": "+countedTokens+"/"+totalTokens
									   +" Complete!");
				}
			}
			s.close();
		}catch(IOException e){
	         e.printStackTrace();
		}
	}
	
	// Counts the number of tokens in a file!
	private int countTokens(File file){
		int count = 0;
		try {
			Scanner s = new Scanner(file);
			while(s.hasNext()){
				s.next();
				count++;
			}
			s.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return count;
	}
	
	// Returns the HitBox that the passed coordinates are inside in.
	public HitBox getHitBox(double x, double y, double z){
		
		
		int chunkX = (int)x / Main.IMAGE_SIZE;
		int chunkY = (int)y / Main.IMAGE_SIZE;
		int chunkZ = (int)z / Main.IMAGE_SIZE;
		
		if(chunkY < 0 || chunkY>=Chunk.MAX_COMPONENTS) {
			return null;
		}
		
		int relX = (int)x % Main.IMAGE_SIZE;
		int relY = (int)y % Main.IMAGE_SIZE;
		int relZ = (int)z % Main.IMAGE_SIZE;
		
		ChunkComponent cc = chunks[chunkX][chunkZ].getComponent(chunkY);
		
		return cc.getHitBox(relX, relY, relZ);
	}
	
	public void addEntity(GameSession session, int x, int y, int z) {
		entities.add(new DebugToxin(session, x, y, z));
	}
	
	// Getter for the category of this map!
	public String getCategory(){
		return category;
	}
	
	// Getter for the name of this map!
	public String getName() {
		return name;
	}
	
	// Getter for the width of this map!
	public int getWidth() {
		return width;
	}
	
	// Getter for the height of this map!
	public int getLength() {
		return length;
	}
	
	// Gets a Chunk of this map at a certain index!
	public Chunk getChunk(int x, int z){
		return chunks[x][z];
	}
	
	// Returns the ArrayList of entities!
	public ArrayList<Entity> getEntities(){
		return entities;
	}
	
}
