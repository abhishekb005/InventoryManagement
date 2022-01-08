import java.util.Scanner;
import java.sql.*;
import java.sql.Date;
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
class UpdateProductQty			//UpdateProductQty.updateProductQuantityStock();
{

	static Connection con=null;
	static Scanner sc=new Scanner(System.in);	
	static												//For database Connection
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/IMS","root","");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	//``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
	 static void updateProductQuantityStock(int a,double b,int c) throws Exception 					//Parametred function to update product qty in Stock DB
	{
		PreparedStatement pst5=con.prepareStatement("UPDATE Product set productQty=? where productId=?");                     
		pst5.setInt(2,a);
		pst5.setDouble(1,b);									
		int res5=pst5.executeUpdate();
		if(c==1)
		{
			if(res5>0)
			{
				System.out.println("Record Updated Successfully");
 			}
			else
			{
				System.out.println("Record not Updated Try Again ");
			}
		}	
	}
}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class ManageStock
{
	static Connection con=null;
	static Scanner sc=new Scanner(System.in);	
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/IMS","root","");
			if(con!=null)
			{
				System.out.println("\t \t \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Online");
			}
			else
			{
				System.out.println("\t \t\t \t \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Offline");
			}
		}
		catch(Exception e)
		{
			System.out.println("Driver Can not be loaded");
		}
	}

	//``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
		
	 static void updateProductQuantityStock() throws Exception 
	{
		
		System.out.println("Enter The Product Id");
		int a1=sc.nextInt();
		System.out.println("Enter New Product Quantity");  		
		Double a2=sc.nextDouble();	
		UpdateProductQty.updateProductQuantityStock(a1,a2,1);								
		
	}

	//``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
	static void viewStock() throws Exception
	{
	PreparedStatement pst=con.prepareStatement("Select * from Product");
	ResultSet res=pst.executeQuery();
	String h1=String.format("\t \t \t \t \t \t %14s \t %14s \t %14s \t %14s \t %14s","Product_ID","ProductName","PurchasePrice","MRP","Product_Qty");
	System.out.println(h1);
	while(res.next())
	{
	String h2=String.format("\t \t \t \t \t \t  %14s \t %14s \t %14s \t %14s \t %14s",res.getInt(1),res.getString(2),res.getInt(3),res.getInt(4),res.getInt(5));
	System.out.println(h2);
	}
	System.out.println("\n\n");
	}
}

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


class ManageProduct
{
	static Connection con=null;
	static Scanner sc=new Scanner(System.in);	
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/IMS","root","");
			if(con!=null)
			{
				System.out.println("\t \t \t \t \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\tOnline");
			}
			else
			{
				System.out.println("\t \t \t \t \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Offline");
			}
		}
		catch(Exception e)
		{
			System.out.println("Driver Can not be loaded");
		}
	}
	//``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
	
	static public void addNewProduct() throws Exception
	{
		PreparedStatement pst=con.prepareStatement("Insert into Product values (?,?,?,?,?)");
		String hh1=String.format(" %115s ","Enter Product Id : ");
		System.out.print(hh1);
		pst.setInt(1,sc.nextInt());
		System.out.println();
		String hh2=String.format(" %115s ","Enter Product Name : ");
		System.out.print(hh2);
		sc.nextLine();
		pst.setString(2,sc.nextLine());
		System.out.println();
		String hh3=String.format(" %115s ","Enter Purchase Price : ");
		System.out.print(hh3);
		pst.setInt(3,sc.nextInt());
		System.out.println();
		String hh4=String.format(" %115s ","Enter Product MRP : ");
		System.out.print(hh4);
		pst.setDouble(4,sc.nextDouble());
		System.out.println();
		String hh5=String.format(" %115s ","Enter Product Quantity : ");
		System.out.print(hh5);
		pst.setInt(5,sc.nextInt());
		System.out.println();
		int res=0;
		res=pst.executeUpdate();
		System.out.println();
		if(res>0)
		{
		System.out.println(" Record inserted");
		}
		if(res==0)
		{
		System.out.println("Record not inserted");
		}
	System.out.println("\n\n");
		
	}
	//``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
	
	static public void viewAllProduct() throws Exception 
	{
	PreparedStatement pst=con.prepareStatement("select * from Product");
	ResultSet res=pst.executeQuery();
	String z1=String.format("\t \t \t \t \t \t %14s \t %14s \t %14s \t %14s \t %14s","Product_ID","Product_Name","Purchase_Price","MRP","Product_Qty");
	System.out.println(z1);
	while(res.next())
	{
	String z2=String.format("\t \t \t \t \t \t %14s \t %14s \t %14s \t %14s \t %14s",res.getInt(1),res.getString(2),res.getInt(3),res.getDouble(4),res.getInt(5));
	System.out.println(z2);
	}
	System.out.println("\n\n");
	}
	
	//``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
	
	static public void removeProduct() throws Exception
	{
	System.out.print("\t \t \t Enter Product Id:");
	int id=sc.nextInt();
	PreparedStatement pst=con.prepareStatement("Delete from Product where productId=?");
	pst.setInt(1,id);
	if(pst.executeUpdate()>0)
	{
	System.out.println("RECORD DELETED ");
	System.out.println();
	}
	else
	{
	System.out.println("INCORRECT Product ID");
	System.out.println();
	}
	}
	
}

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class ProfitLoss 
{
	static Connection con=null;
	static Scanner sc=new Scanner(System.in);	
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/IMS","root","");
			if(con!=null)
			{
				System.out.println("\t \t \t \t \t \t \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \tOnline");
			}
			else
			{
				System.out.println("\t \t\t \t \t \t \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Offline");
			}
		}
		catch(Exception e)
		{
			System.out.println("Driver Can not be loaded");
		}
	}
	//``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
	
	static public void ViewProfitDetails() throws Exception
	{
	PreparedStatement pst=con.prepareStatement("SELECT productId,productName,productPrice,Price,saleQty,((Price-productPrice)*saleQty),date FROM product,sale WHERE productId=productId1 AND date=?");
	System.out.println(" \t  \t  \t \t  \t  \t \t  \t  \t  Enter Date to View Profit-Loss Statement");
	System.out.print(" \t  \t  \t \t  \t  \t \t  \t  \t \t \t  : ");
	String str=sc.next();  
	System.out.println("\n");
    	Date date=Date.valueOf(str);                                                                                                     //converting string into sql date  
	pst.setDate(1,date);
	ResultSet res=pst.executeQuery();
	String t1=String.format(" \t\t %14s \t %14s \t %14s \t %14s \t %14s \t %14s \t %14s","Product_ID","ProductName","PurchasePrice","MRP","Quantity","Profit_per_item","Date");
	System.out.println(t1);
	while(res.next())
	{
		String t2=String.format(" \t\t %14s \t %14s \t %14s \t %14s \t %14s \t %14s \t %14s",res.getInt(1),res.getString(2),res.getInt(3),res.getInt(4),res.getInt(5),res.getInt(6),res.getDate(7));
		System.out.println(t2);
	}
	System.out.println();
	PreparedStatement pst1=con.prepareStatement("select SUM((Price-productPrice)*saleQty) AS Profit FROM product,sale WHERE productId=productId1 AND date=?;");
	pst1.setDate(1,date);
	ResultSet res1=pst1.executeQuery();
	String q1=String.format("%140s","Total Profit  :");
	System.out.print(q1);
	while(res1.next())
	{
		String q2=String.format("%8s",res1.getInt(1));
		System.out.println(q2);
	
	}
	}
}

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Sale
{	
	static Connection con=null;
	static Scanner sc=new Scanner(System.in);
	static 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ims","root","");
			if(con!=null)
			{
				System.out.println("\t \t \t \t \t \t \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \tOnline");
			}
			else
			{
				System.out.println("\t \t \t \t \t \t \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \tOffline");
			}
	
		}
		catch(Exception e)
		{
			System.out.println("cannot load Driver");
		}
	}
	//``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
	
	public static void insertProductSaleDetails() throws Exception
	{
		System.out.print("\t Enter Product ID : ");
		int id1=sc.nextInt();
		System.out.println();
		System.out.print("\t Enter Sale ID : ");
		int sid=sc.nextInt();
		System.out.println();
		System.out.print("\t Enter Price");
		int mrp=sc.nextInt();
  		System.out.println();
		System.out.print("\t Enter Date (YYYY-MM-DD) : ");
		String dam=sc.next();
		System.out.println();
		Date date=Date.valueOf(dam);
		int Qty=0;
		int Qty1=0;
		int Qty2=0;
		
		int i=0;
		while(i!=1)
		{
		PreparedStatement pst1=con.prepareStatement("Select  productQty from Product where productId=?");
		pst1.setInt(1,id1);
		ResultSet Ress1=pst1.executeQuery();
		Ress1.next();	
		Qty2=Ress1.getInt(1);             					//Qty2 contain productQty from stock
		System.out.println("Stock Contain :"+Qty2);
		//sc.nextInt();					
		System.out.println("\t Sale Quantity : ");
		Qty=sc.nextInt();						//Qty is sale Qty
			
			if(Qty2>=Qty)
			{
			Qty1=Qty2-Qty;     						//Qty1 contain productQty when next purchase is made
			i=1;
			UpdateProductQty.updateProductQuantityStock(id1,Qty1,0);
			System.out.println("Now Stock contain :"+Qty1);
			}
			else
			{
			System.out.println("Re-Enter: Sale Quantity should be less than or equal to Product Quantity in Stock ");
			}
			
		}

		
		//PreparedStatement pst2=con.prepareStatement("Update product set productQty=? where productId=?");
		//pst2.setDouble(1,Qty1);
		//pst2.setInt(2,id1);

		PreparedStatement pst=con.prepareStatement("insert into sale values(?,?,?,?,?) ");
		pst.setInt(1,id1);
		pst.setInt(2,sid);
		pst.setInt(3,Qty);
		pst.setDouble(4,mrp);	                                                                               //setDecimal doubt?
		pst.setDate(5,date);

		int res=pst.executeUpdate();
		if(res>0)
		{
		System.out.println("Record inserted");
		}
		else
		{
		System.out.println("Record not inserted");
		}

	}
	//``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
	
	
	public static void viewProductSaleDetails() throws Exception
	{
	System.out.println();
	PreparedStatement pst=con.prepareStatement("select * from sale");
	ResultSet res=pst.executeQuery();
	String h1=String.format("\t \t \t \t \t %14s \t %14s \t %14s \t %14s \t %14s","Product_Id","Sale_Id","Sale_Qty","Price","Date");
	System.out.println(h1);
	while(res.next())
	{
	String h2=String.format("\t \t \t \t \t %14s \t %14s \t %14s \t %14s \t %14s ",res.getInt(1),res.getInt(2),res.getInt(3),res.getDouble(4),res.getDate(5));
	System.out.println(h2);
	}
	}

	//``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
	

   	static void updateProductSaleDetails()  throws Exception
		{
		System.out.print("\t Enter Product Id : ");
		int id=sc.nextInt();
		System.out.println();
		PreparedStatement pst=con.prepareStatement("select * from sale where productId1=? ");
		pst.setInt(1,id);
		ResultSet res=pst.executeQuery();
		if(res.next())
		{
		PreparedStatement pst1=con.prepareStatement("update sale set saleId=?, saleQty=?,Price=?,date=? Where productId1=?; ");
		System.out.print("\t Enter the Sale ID ");
		pst1.setInt(1,sc.nextInt());
		System.out.println();
		int i=0;
		int Qty=1;
		int Qty1=0;
		int Qty2=0;
		while(i!=1)
		{
		PreparedStatement pst2=con.prepareStatement("Select  productQty from Product where productId=?");
		pst2.setInt(1,id);
		ResultSet Ress1=pst2.executeQuery();
		Ress1.next();	
		Qty2=Ress1.getInt(1);             					//Qty2 contain productQty from stock
		System.out.println("Quantity in stock :"+Qty2);
		System.out.println("Sale Quantity : ");
		Qty=sc.nextInt();				//Qty is sale Qty
		System.out.println();
			if(Qty2>=Qty)
			{
			pst1.setInt(2,Qty);
			Qty1=Qty2-Qty;     						//Qty1 contain productQty when next purchase is made
			i=1;
			}
			else
			{
			System.out.println("Re-Enter: Sale Quantity should be less than or equal to Product Quantity in Stock ");
			}
		}
			System.out.println("Quantity In Stock Now  :"+Qty1);
			UpdateProductQty.updateProductQuantityStock(id,Qty1,0);

			//PreparedStatement pst3=con.prepareStatement("UPDATE `product` SET  `productQty`=? WHERE `productId`=?");
			//pst3.setDouble(1,Qty1);
			//pst3.setInt(2,id);
			
			System.out.print("Enter Price  ");
			double mrp=sc.nextDouble();
			pst1.setDouble(3,mrp);
			System.out.print("Enter Date (YYYY-MM-DD)");
			String src=sc.next();
			System.out.println();
			Date date=Date.valueOf(src);
			pst1.setDate(4,date);
			pst1.setInt(5,id);                                                                                                                                   
			int ress=pst1.executeUpdate();
			if(ress>0)
			{
				System.out.println("RecordUpdated....");
			}
			else
			{
			System.out.println("Record NOT Updated....");
			}


		}	
}
}

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Blankscreen
{
	public static void clearScreen()
	{
		try
		{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}
		catch(Exception e)
		{}
	}
}

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


class Inventary
{
	public static void main(String...arg)
	{
		Scanner sc=new Scanner(System.in);
		Blankscreen.clearScreen();
		while(true)
		{
		 
		System.out.println("\n");
		String a1=String.format("%120s","Welcome To Inventary Management System");
		System.out.println(a1);
		String a2=String.format("%120s","~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(a2+"\n");
		String a3=String.format("%105s","Enter User Id :");
		System.out.print(a3);
		int userid=sc.nextInt();
		String a4=String.format("%106s","Enter Password :");
		System.out.print(a4);
		int password=sc.nextInt();
		 Blankscreen.clearScreen();
		
		if(userid==123 && password==123)
		{
		while(true)
		{
			System.out.println("\n \n");
			System.out.println(" \t  \t \t \t \t  \t  \t \t \t \t \t \t  MAIN MENU ");
			System.out.println("\n");
			System.out.println("\tPress 1 to Manage Stock");
			System.out.println("\tPress 2 to Sell");
			System.out.println("\tPress 3 to Manage Products");			
			System.out.println("\tPress 4 to View Profit Details");
			System.out.println("\tPress 5 for Exit");

			System.out.print(" \t \t \t\t \t \t Enter your choice :  \t");

			int choice=sc.nextInt();


														

			switch(choice)
			{
				case 1:  
					 Blankscreen.clearScreen();
					System.out.println("\n \n");
					System.out.println("\t  \t \t \t \t  \t  \t \t \t \t \t \t   SUB MENU : ");
					System.out.println("\n");
					System.out.println("\t Press 1 to Update Product Quantity in Stock");
					System.out.println("\t Press 2 to View Stock");
					System.out.println("\t Press 3 to  Back to Main Menu");
					System.out.print(" \t \t \t\t \t \t Enter your choice :  \t");
					int ch=sc.nextInt();
					switch(ch)
					{
						case 1 :
							try{
							ManageStock.updateProductQuantityStock();
							}
							catch(Exception e){System.out.println(e+"");}						
							break;

						case 2 :
							try{
							ManageStock.viewStock();
							}
							catch(Exception e){System.out.println(e+"\t");}						
							break;

						case 3 :      
							  Blankscreen.clearScreen();

						
							break;	
					}   
					
										
					break;
				case 2: 
					 Blankscreen.clearScreen();
					System.out.println("\n \n");
					System.out.println("\t  \t \t \t \t  \t  \t \t \t \t \t \t  SUB MENU : ");
					System.out.println("\n \n");
					System.out.println("\t Press  1 to Insert Sale Details");
					System.out.println("\t Press 2 to update  Sale Details");
					System.out.println("\t Press  3 to View  Sale Details");
					System.out.println("\t Press 4 to Back to Main menu ");
					System.out.print("\t \t\t\t Enter Your Choice :");
					int n=sc.nextInt();
					System.out.println();
					switch(n)
					{
						case 1 :	
							try{
							Sale.insertProductSaleDetails();
							}
							catch(Exception e){
							System.out.println(e+"Record not Inserted"); }
						break;

						case 2 :
							try{
							Sale.updateProductSaleDetails();
							}
							catch(Exception e){ System.out.println(e);} 

						break;

						case 3 :
							try{
							Sale.viewProductSaleDetails();
							}
							catch(Exception e){ System.out.println(e);}
							

						break;
						case 4 :
							 Blankscreen.clearScreen();
						 
						break;

					}   
					break;

				 case 3:
					Blankscreen.clearScreen();
					System.out.println("\n \n");
					System.out.println("\t  \t \t \t \t  \t  \t \t \t \t \t \t  SUB MENU : ");
					System.out.println("\n \n");
					System.out.println("\t Press  1 to Add New Product In Stock ");
					System.out.println("\t Press 2 to  View All Products In Stock ");
					System.out.println("\t Press 3 to Remove Product From Stock ");
					System.out.println("\t Press 4 to back Main Menu ");
					System.out.print("\t \t\t\t Enter Your Choice :");
					int n1=sc.nextInt();


					switch(n1)
					{
						case 1 :
							 Blankscreen.clearScreen();
							try{
							ManageProduct.addNewProduct();
							}
							catch(Exception e){System.out.println(e+"Record not inserted");}

						break;

						case 2 :
							try{
							ManageProduct.viewAllProduct();
							}
							catch(Exception e){System.out.println(e+"\t");}

						break;

						case 3 :
							try{
							ManageProduct.removeProduct();
							}
							catch(Exception e){System.out.println(e+"");}

						break;

						case 4 :
							 Blankscreen.clearScreen();
																		
							break;
					};


					break;
				case 4:
					
					try{
					ProfitLoss.ViewProfitDetails();
					}
					catch(Exception e){System.out.println(e);}
					break;


				case 5:
					try{
					Blankscreen.clearScreen();
					System.exit(0);
					}catch(Exception e){System.out.println(e);}
					break;
					   

					
			}					

		}						

		}else{System.out.println("\t\t\t\t\t\t\t\t\t\tInvalid User Id and Password : Please Try Again ");}
	}
	}


}

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



