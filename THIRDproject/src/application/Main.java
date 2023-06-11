package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class Main extends Application {
	TawjihiDS tawjihiDB=new TawjihiDS();
	   
	@Override
	public void start(Stage primaryStage) {
		try {
			  BorderPane root = new BorderPane();
			  root.setPadding(new Insets(5));
			  root.setPadding(new Insets(10));
		     
		      GridPane gp=new GridPane();
		      gp.setAlignment(Pos.CENTER_LEFT);
		      Image image = new Image("graduationgif.gif");
		      ImageView imageView = new ImageView();
		      imageView.setImage(image);    
		      imageView.setFitWidth(300);
		      imageView.resize(1530, 40);
		      imageView.setPreserveRatio(true); 
		      imageView.setTranslateY(0);
		      root.setRight(imageView);
		      
		   //   la.setFont(Font.font("Times new Roman"));
		    //  gp.addRow(4, la);
		     

		      Label  branch =new Label(" SELECT:  ");
				branch.setFont(new Font("Times New Roman",20));
				branch.setTextFill(Color.BLACK);
				
				RadioButton literary=new RadioButton("Literary");
				RadioButton scientific=new RadioButton("scientific");
				literary.setFont(Font.font("Lucida Sans Unicode",  15));
				literary.setTextFill(Color.BLACK);
				scientific.setFont(Font.font("Lucida Sans Unicode", 15));
				scientific.setTextFill(Color.BLACK);
			     ToggleGroup group2 = new ToggleGroup();
			     literary.setToggleGroup(group2);
			     scientific.setToggleGroup(group2);
				//gp.addRow(1, region,gaza,westb);	
				//gp.addRow(2, branch,literary,scientific);
			     Button read=new Button("CHOOSE YOUR FILE");
			     read.setFont(Font.font("Lucida Sans Unicode",11));
			     read.setTextFill(Color.BLACK);
					read.setStyle("-fx-background-color:MISTYROSE;");

			    
			     Label view=new Label();
			     VBox vb1=new VBox(branch);
			     VBox vb2=new VBox(literary);
			     VBox vb3=new VBox(scientific);
				  vb1.setTranslateX(15);
				  vb2.setTranslateX(22);
				  vb3.setTranslateX(24);
			      gp.addRow(4,vb1,vb2,vb3);
			      read.setTranslateX(15);
			      view.setTranslateX(290);
			      gp.addRow(6, read);
			      gp.addRow(8, view);
/////////////////////////////////////////////////////////////////////////			   
			     FileChooser fileChooser = new FileChooser();
			      read.setOnAction(e-> {
			       File selectedFile = fileChooser.showOpenDialog(primaryStage);
			      // System.out.println(selectedFile.toString());
			    	  if (!((literary.isSelected() || scientific.isSelected() )))
		        		{
		        		  //if the user does not select the region and branch
			    		  view.setText("select branch");		   
			    		  view.setTextFill(Color.BLACK);
		        	      System.out.println("select branch");
		        	      
		        		}
			    	  else if ( literary.isSelected()  )
		        	  {
			    		  
		        		  view.setText("file has been read");		   
			    		  view.setTextFill(Color.BLACK);
			    		  System.out.println("literary");
					      tawjihiDB.readFromFileLit(selectedFile.toString());			
		  		       }  
			    	  else if ( scientific.isSelected()  )
		        	  {
		        		  view.setText("scientific ");		   
			    		  view.setTextFill(Color.BLACK);          
		  		          // read from gaza file  
					      tawjihiDB.readFromFileSC(selectedFile.toString());
		        	  }			    			   
			      });
		    root.setTop(gp);       
		    BorderPane gp2=new BorderPane();
		 //   gp2.setAlignment(Pos.CENTER);
		    Button insert=new Button (" insert ");
			Button delete=new Button (" delete ");
			Button search=new Button (" search");
			Button update=new Button (" update ");
			Button printDoubleLS=new Button (" show CircularDoubleLinkedList");
			Button printfirstAVL=new Button (" show 1st AVL");
			Button printsecondAVL=new Button (" show 2nd AVL");
			//Button height=new Button (" AVL’s height");
		//	Button getAll=new Button("get All");
			insert.setPrefSize(260, 40);
			insert.setFont(Font.font("Times new Roman",  15));
			insert.setStyle("-fx-background-color:MISTYROSE;");
			delete.setPrefSize(260, 40);
			delete.setFont(Font.font("Times new Roman",  15));
			delete.setStyle("-fx-background-color:MISTYROSE;");
			search.setPrefSize(260, 40);
			search.setFont(Font.font("Times new Roman",  15));
			search.setStyle("-fx-background-color:MISTYROSE;");
			update.setPrefSize(260, 40);
			update.setFont(Font.font("Times new Roman",  15));
			update.setStyle("-fx-background-color:MISTYROSE;");
			printDoubleLS.setPrefSize(260, 40);
			printDoubleLS.setFont(Font.font("Times new Roman",  15));
			printDoubleLS.setStyle("-fx-background-color:MISTYROSE;");
			printfirstAVL.setPrefSize(260, 40);
			printfirstAVL.setFont(Font.font("Times new Roman",  15));
			printfirstAVL.setStyle("-fx-background-color:MISTYROSE;");		
			printsecondAVL.setPrefSize(260, 40);
			printsecondAVL.setFont(Font.font("Times new Roman",  15));
			printsecondAVL.setStyle("-fx-background-color:MISTYROSE;");			
		//	height.setPrefSize(260, 40);
		//	height.setFont(Font.font("Times new Roman",  15));
		//	height.setStyle("-fx-background-color:MISTYROSE;");	
		//	getAll.setPrefSize(260, 40);
		//	getAll.setFont(Font.font("Times new Roman",  15));
			//getAll.setStyle("-fx-background-color:MISTYROSE;");	
			VBox vbB=new VBox(10,insert,delete,search,update,printDoubleLS,printfirstAVL,printsecondAVL);
			vbB.setTranslateY(2);
			vbB.setTranslateX(10);
			vbB.setAlignment(Pos.CENTER_LEFT);
			gp2.setRight(vbB);
		    root.setLeft(gp2);
////////////////////////////////////////////////////////////////////////////////////////////////
		    insert.setOnAction(e->{
				GridPane gpi = new GridPane();
				TextField tf1=new TextField();
				tf1.setPromptText("enter a seatNumber to insert");
				tf1.setPrefSize(90, 20);			
				TextField tf2=new TextField();
				tf2.setPromptText("her/his grade");
				tf2.setPrefSize(90, 20);
                Button add=new Button("insert");
            	add.setPrefSize(60, 30);
    			add.setFont(Font.font("Time new ramen", 10));
				gpi.addRow(1, tf1);
				gpi.addRow(2, tf2);
				gpi.addRow(3, add);	
				gpi.setTranslateX(300);
				gpi.setTranslateY(-300);
				Label select=new Label();
			    Background bk=new Background(new BackgroundFill(Color.MISTYROSE,new CornerRadii(0),new Insets(0)));
				add.setStyle("-fx-background-color:PLUM;");	

				gpi.setBackground(bk);
				gpi.setAlignment(Pos.CENTER_LEFT);	
				add.setOnAction(e1->{			
			try {		
				if (!(literary.isSelected() || scientific.isSelected() ))
        		{
				  select.setText(" select branch ");
        		  select.setTextFill(Color.DARKRED);
  		          gpi.addRow(5, select);
        	       System.out.println("select branch");		        	         
        		}
				else if ( literary.isSelected()  ) {
					 //if the user select gaza and literally
					 //   tawjihiRecord tr=new tawjihiRecord(Integer.parseInt(tf1.getText()),"Literary",Double.parseDouble(tf2.getText()));
					     if ( tawjihiDB.isExistLit(Integer.parseInt(tf1.getText())) == true)
						  {
					    	  System.out.println("a student with that seat number already exists");
			        	      select.setText("a student with that seat number already exists");
			        		  select.setTextFill(Color.DARKRED);
						  }
					     else   if (Integer.parseInt(tf2.getText())>100|| Integer.parseInt(tf2.getText())<50 ) {
					    	 select.setText("Error, enter a valid grade greater than 50 and less than 100");
			        		 select.setTextFill(Color.DARKRED);
					    }
					     else  if(tawjihiDB.isExistLit(Integer.parseInt(tf1.getText())) == false) {
					        tawjihiDB.addRecordLit(new TawjihiRecord(Integer.parseInt(tf1.getText()),"Literary",Double.parseDouble(tf2.getText())));
		        	      select.setText("Done");
		        		  select.setTextFill(Color.DARKGREEN);
					    }
		  				  gpi.addRow(5, select);
		  				  }
				
				 else if (  scientific.isSelected() ) {
					 //if the user select gaza and literally
					 //   tawjihiRecord tr=new tawjihiRecord(Integer.parseInt(tf1.getText()),"Literary",Double.parseDouble(tf2.getText()));
					     if ( tawjihiDB.isExistSC(Integer.parseInt(tf1.getText())) == true)
						  {
					    	  System.out.println("a student with that seat number already exists");
			        	      select.setText("a student with that seat number already exists");
			        		  select.setTextFill(Color.DARKRED);
						  }
					    
				 
				 
					     else  if(tawjihiDB.isExistSC(Integer.parseInt(tf1.getText())) == false) {
					    	    if (Integer.parseInt(tf2.getText())>100|| Integer.parseInt(tf2.getText())<50) {
						    	 select.setText("Error, enter a valid grade greater than 50 and less than 100");
				        		 select.setTextFill(Color.DARKRED);
						    }
					    	    else {
					        tawjihiDB.addRecordSC(new TawjihiRecord(Integer.parseInt(tf1.getText()),"Literary",Double.parseDouble(tf2.getText())));
		        	      select.setText("Done");
		        		  select.setTextFill(Color.DARKGREEN);
					    }
					     }
		  				  gpi.addRow(5, select);
		  				  }
			    } catch (Exception e2)
			{
				select.setText("Entry Error");
				select.setTextFill(Color.DARKRED);
				
				gpi.addRow(5,select);
				System.out.print(e2.getMessage());
			}
				});	
				gp2.setBottom(gpi);
			    		
			});
//////////////////////////////////////////////////////////////////////////////////////////////
		    delete.setOnAction(e->{
				GridPane gpi = new GridPane();
				//Label seat=new Label("seat number ");
				TextField tf1=new TextField();
				tf1.setPromptText("seat number");
				tf1.setPrefSize(90, 20);               
				Button remove=new Button("remove");
				remove.setStyle("-fx-background-color:PLUM;");	

    			remove.setPrefSize(50, 20);
    			remove.setFont(Font.font("Lucida Sans Unicode", 10));
				gpi.addRow(1, tf1);
				 Label select=new Label();
				gpi.addRow(3, remove,select);
				  Background bk=new Background(new BackgroundFill(Color.MISTYROSE,new CornerRadii(0),new Insets(0)));
					gpi.setTranslateX(300);
					gpi.setTranslateY(-300);
					gpi.setBackground(bk);
				gpi.setAlignment(Pos.CENTER_LEFT);
				gp2.setBottom(gpi);	
				remove.setOnAction(e1->{
				try {	
					if (!(literary.isSelected() || scientific.isSelected() ))
	        		{ //if the user does not select the branch and the region
	        		  select.setText("select region and branch");
	        		  select.setTextFill(Color.DARKRED);
	  		          //gpi.addRow(3, select);
	        	       System.out.println("select region and branch");		        	         
	        		}
					 if (  scientific.isSelected()  ) {
					     if ( tawjihiDB.isExistSC(Integer.parseInt(tf1.getText())) == true)
					     {
					    	 tawjihiDB.removeRecordSC(Integer.parseInt(tf1.getText()));
					    	 select.setText("Done");
			        		 select.setTextFill(Color.DARKGREEN);    	 
					     }
					     else {
					    	 select.setText("not found");
			        		  select.setTextFill(Color.DARKRED);
					     }
							
						 }
					 if(literary.isSelected()) {
						 if ( tawjihiDB.isExistLit(Integer.parseInt(tf1.getText()))== true)
					     {
					    	 tawjihiDB.removeRecordLit(Integer.parseInt(tf1.getText()));
					    	 select.setText("Done");
			        		 select.setTextFill(Color.DARKGREEN);
					    	 
					     }
						 else {
							 select.setText("not found");
			        		  select.setTextFill(Color.DARKRED);
						 }
												 
					 }
					
				} catch (Exception e2)
				{
					select.setText("Entry Error");
					select.setTextFill(Color.DARKRED);
					System.out.print(e2.getMessage());
				}
							
				});
		    });
///////////////////////////////////////////////////////////////////////////////////////////////////
		    search.setOnAction(e->{
				GridPane gpi = new GridPane();
			//	Label seat=new Label("seat number ");
				TextField tf1=new TextField();
				tf1.setPromptText("seat number");
				tf1.setPrefSize(90, 20);
				
				tf1.setPrefSize(80, 20);
                Button check=new Button("search");
              //  seat.setFont(Font.font("Lucida Sans Unicode",  15));
    			check.setPrefSize(60, 20);
    			check.setFont(Font.font("Lucida Sans Unicode", 10));
				check.setStyle("-fx-background-color:PLUM;");	

				gpi.addRow(0, tf1,check);
				 Label select=new Label();
				gpi.addRow(1,select);
				//gpi.setTranslateX(50);
				//gpi.setTranslateY(-200);
                Button next=new Button("next");
                Button prev=new Button("prev");
				next.setStyle("-fx-background-color:PLUM;");	
				prev.setStyle("-fx-background-color:PLUM;");	
				gpi.addRow(2, prev,next);
				  Background bk=new Background(new BackgroundFill(Color.MISTYROSE,new CornerRadii(0),new Insets(0)));

					gpi.setBackground(bk);
				gpi.setAlignment(Pos.CENTER_LEFT);
				gp2.setBottom(gpi);	
				gpi.setTranslateX(300);
				gpi.setTranslateY(-300);
				
				check.setOnAction(e1->{
					try {
					if (!((literary.isSelected() || scientific.isSelected() )))
	        		{ //if the user does not select the branch and the region
	        		   select.setText("select branch");
	        		   select.setTextFill(Color.RED);
	        	       System.out.println("select region and branch");		        	         
	        		}
					 else if (literary.isSelected()  ) {
						// if the user select the gaza and literally
					  tawjihiDB.searchBySeatNumberLit(Integer.parseInt(tf1.getText()));
			           select.setText(tawjihiDB.searchBySeatNumberLit(Integer.parseInt(tf1.getText())).toString()); 
			           next.setOnAction(e2->{
				           select.setText(tawjihiDB.getNextLit(Integer.parseInt(tf1.getText())).toString()); 
				           //tawjihiDB.getNextLit(Integer.parseInt(tf1.getText())).student.getSeatNumber();
				         //  tf1.setText((tawjihiDB.getNextLit(Integer.parseInt(tf1.getText())).student.getSeatNumber()));
			           });
			           prev.setOnAction(e2->{
				           select.setText(tawjihiDB.getPrevLit(Integer.parseInt(tf1.getText())).toString()); 
			           });
					 }
					 else if (scientific.isSelected()) {
						 tawjihiDB.searchBySeatNumberSC(Integer.parseInt(tf1.getText()));
				         select.setText(tawjihiDB.searchBySeatNumberSC(Integer.parseInt(tf1.getText())).toString()); 
				         next.setOnAction(e2->{
					           select.setText(tawjihiDB.getNextSC(Integer.parseInt(tf1.getText())).toString()); 
				           });
				           prev.setOnAction(e2->{
					           select.setText(tawjihiDB.getPrevSC(Integer.parseInt(tf1.getText())).toString()); 
				           });
					 }
					}catch (Exception e2)
						{
						select.setText("Entry Error");
							//ta.setTextFill(Color.DARKRED);
							System.out.print(e2.getMessage());
						}			
				});

		    });
////////////////////////////////////////////////////////////////////////////////////////////////
		    update.setOnAction(e->{
				GridPane gpi = new GridPane();
				gpi.setHgap(5);
				gpi.setVgap(5);

				TextField tf1=new TextField();
				tf1.setPromptText("seat number");
				tf1.setPrefSize(90, 20);
                Button check=new Button("Check");
                check.setPrefSize(50, 20);
				gpi.addRow(1,tf1,check);
				  Background bk=new Background(new BackgroundFill(Color.MISTYROSE,new CornerRadii(0),new Insets(0)));
					gpi.setTranslateX(300);
					gpi.setTranslateY(-300);
					gpi.setBackground(bk);
					check.setStyle("-fx-background-color:PLUM;");	

				check.setOnAction(e1->{
			 if (!((literary.isSelected() || scientific.isSelected() )))
			 {
				 
			 }
			  if (literary.isSelected()  ) {
				  System.out.println(Integer.parseInt(tf1.getText().trim())+" hh");
				  int num=Integer.parseInt(tf1.getText());
				  System.out.println(tawjihiDB.isExistLit(num));
				  System.out.println(tawjihiDB.searchBySeatNumberLit(Integer.parseInt(tf1.getText())));
                  
				if (tawjihiDB.isExistLit(Integer.parseInt(tf1.getText())) == false) 
				{
					System.out.println("not found");
				}
				if (tawjihiDB.isExistLit(Integer.parseInt(tf1.getText())) == true) 
				{
				TextField tf2=new TextField();
				tf2.setPromptText("new grade");
				tf2.setPrefSize(80, 20);
			//	TextField tf3=new TextField();
			//	tf3.setPromptText("new branch");
				tf2.setPrefSize(80, 20);
                Button upd=new Button("update");
              //  seat.setFont(Font.font("Lucida Sans Unicode",  15));
    			upd.setPrefSize(60, 20);
    			upd.setFont(Font.font("Lucida Sans Unicode", 10));
				gpi.addRow(3,tf2);
		//		gpi.addRow(4,tf3);
				gpi.addRow(5, upd);				
				CircularDoublyLinkedListNode nodeLit=tawjihiDB.searchBySeatNumberLit(Integer.parseInt(tf1.getText()));	
				upd.setOnAction(e2->{
		        nodeLit.TawjihiRecord.setAvg(Double.parseDouble(tf2.getText()));
		   //     nodeLit.student.setBranch(tf3.getText());
				});				
			}
		}
			  ////
			  if (scientific.isSelected()  ) {

				//  System.out.println(Integer.parseInt(tf1.getText().trim())+" hh");
				  int num=Integer.parseInt(tf1.getText());
				  System.out.println(tawjihiDB.isExistSC(num));
				  System.out.println(tawjihiDB.searchBySeatNumberSC(Integer.parseInt(tf1.getText())));

				if (tawjihiDB.isExistSC(Integer.parseInt(tf1.getText())) == false) 
				{
					System.out.println("not found");
				}
				if (tawjihiDB.isExistSC(Integer.parseInt(tf1.getText())) == true) 
				{
				TextField tf2=new TextField();
				tf2.setPromptText("new grade");
				tf2.setPrefSize(80, 20);
			//	TextField tf3=new TextField();
			//	tf3.setPromptText("new branch");
				tf2.setPrefSize(80, 20);
                Button upd=new Button("update");
              //  seat.setFont(Font.font("Lucida Sans Unicode",  15));
    			upd.setPrefSize(60, 20);
    			upd.setFont(Font.font("Lucida Sans Unicode", 10));
				gpi.addRow(3,tf2);
		//		gpi.addRow(4,tf3);
				gpi.addRow(5, upd);				
				CircularDoublyLinkedListNode nodeLit=tawjihiDB.searchBySeatNumberSC(Integer.parseInt(tf1.getText()));	
				upd.setOnAction(e2->{
		        nodeLit.TawjihiRecord.setAvg(Double.parseDouble(tf2.getText()));
		   //     nodeLit.student.setBranch(tf3.getText());
				});				

				}
			}	  			  
			 ////
		  });	
				gpi.setAlignment(Pos.CENTER_LEFT);	
				gp2.setBottom(gpi);
		    });		   
///////////////////////////////////////////////////////////////////////////////////////////////////
		    printDoubleLS.setOnAction(e->{
		    	TextArea ta=new TextArea();
		    	Stage stg=new Stage();
				  if (literary.isSelected()  ) {
					  
					  ta.setText(tawjihiDB.printListLit());
				  }
				  if (scientific.isSelected()  ) {
					ta.setText(tawjihiDB.printListSC());
				  }	
				  stg.setScene(new Scene(ta,380,470));
				  stg.show();
				  
		    });
////////////////////////////////////////////////////////////////////////////////////////////////
		    printfirstAVL.setOnAction(e1->{
		    	TextArea ta=new TextArea();
		    	Stage stg=new Stage();
				  if (literary.isSelected()  ) {
					 System.out.println("---------------------------------------"); 
					  ta.setText("seat number \n"+tawjihiDB.printAVL_OneLitSTLit());

				  }
				  if (scientific.isSelected()  ) {
					ta.setText("seat number \n"+tawjihiDB.printAVL_OneLitSTSC());
				  }	
				  stg.setScene(new Scene(ta,380,470));
				  stg.show();
		    });
////////////////////////////////////////////////////////////////////////////////////////////////
		     printsecondAVL.setOnAction(e1->{
		    	TextArea ta=new TextArea();
		    	Stage stg=new Stage();
				  if (literary.isSelected()  ) {
					 System.out.println("---------------------------------------"); 
					  ta.setText("avg \n"+tawjihiDB.printAVL_TwoLit());

				  }
				  if (scientific.isSelected()  ) {
					ta.setText("avg \n"+tawjihiDB.printAVL_TwoSC());
				  }	
				  stg.setScene(new Scene(ta,380,470));
				  stg.show();
		    });
/////////////////////////////////////////////////////////////////////////////
		     
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		     
	////////////////////////////////////////////////////////////////////////////////////////////////////////////	    	    
		    Scene scene = new Scene(root,960,520);
			Background bk = new Background(new BackgroundFill(Color.BEIGE,new CornerRadii(0),new Insets(0)));
			root.setBackground(bk);
			root.setAlignment(gp, Pos.CENTER_RIGHT);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		TawjihiDS db=new TawjihiDS();
	
	   

	}
}
