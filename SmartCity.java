import java.util.Scanner;
class Colours
{
    static final String def = "\u001b[0;1m";
    static final String blink = "\u001b[5m";
    static final String red =  "\u001b[31;1m";
    static final String green = "\u001b[32;1m";
    static final String yellow = "\u001b[33;1m";
    static final String blue = "\u001b[34;1m";
    static final String purpe = "\u001b[35;1m";
    static final String skblue = "\u001b[36;1m";
    static final String bgred =  "\u001b[101;1m";
    static final String bggreen = "\u001b[102;1m";
    static final String bgyellow = "\u001b[103;1m";
    static final String bgblue = "\u001b[104;1m";
    static final String bgpurpe = "\u001b[105;1m";
    static final String bgskblue = "\u001b[106;1m";
}

class Login extends Colours
{
    static Scanner sc = new Scanner(System.in);
    private long phoneNumber;
    private String emailId;
    void setPhoneNumber(long phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }
    long getPhoneNumber()
    {
        return phoneNumber;
    }
    String getEmailId()
    {
        return emailId;
    }
    boolean isValidPhoneNumber(long phoneNumber)
    {
        int digitCount = 0;
        while (phoneNumber != 0)
        {
            phoneNumber = phoneNumber / 10;
            digitCount++;
        }
        return digitCount == 10;
    }
    void generateOTP()
    {
        boolean rotp=false;
        while(!rotp)
        {
            System.out.print("Enter Generated OTP: ");
            int randomotp = 1001 + (int)(Math.random() * 8999);
            System.out.println(randomotp);
            int eotp=sc.nextInt();
            if(eotp==randomotp)
            {
                System.out.println(red + "Mobile Number Verified Successfully" + def);
		System.out.println(green + "   **********SUCCESSFULLY LOGINED**********   " + def);
		System.out.println();
                rotp=true;
            }
            else
            {
                System.out.println("Enter new OTP sent");
            }
        }
    }
    Login()
    {
        boolean validNumber = false;
        while (!validNumber)
        {
            System.out.print("Enter Phone Number: ");
            phoneNumber = sc.nextLong();
            if (isValidPhoneNumber(phoneNumber))
            {
                validNumber = true;
                setPhoneNumber(phoneNumber);
                System.out.println("Phone number accepted.");
                generateOTP();
            }
            else
            {
                System.out.println(red + "Invalid phone number. Please enter a 10-digit phone number." + def);
            }
        }
    }
}
class Profile extends Login
{
    static Scanner sc = new Scanner(System.in);
    private String name;
    private String address;
    private long phoneNumber;
    private String emailId;
    private double walletBalance;

 	Profile()
	{
		System.out.println(skblue + "   *   ___________**USER PROFILE**___________   *" + def);
		System.out.println();
		System.out.print(green + "Enter your Name    :" + def);
		this.name = sc.next();
        	System.out.print(green + "Enter your Address :" + def);
		this.address = sc.next();
		this.phoneNumber = getPhoneNumber();
       		boolean b = true;
		while (b) 
		{
			System.out.print(green + "Enter your EmailId :" + def );
    			String s = sc.next();
    			if (s.endsWith("@gmail.com")) 
			{
        			this.emailId = s;
        			b = false;
    			} 
			else 
			{
        			System.out.println(red + "Invalid EmailID. Please enter a valid Email ID ending with" + def + " @gmail.com ");
    			}
		}
		this.walletBalance = addCashback();
	}

    String getName()
    {
        return name;
    }

    String getAddress()
    {
        return address;
    }

    long getPhoneNumber()
    {
        return phoneNumber;
    }

    String getEmailId()
    {
        return emailId;
    }

    double getWalletBalance()
    {
        return walletBalance;
    }


    void setName(String name)
    {
        this.name = name;
    }

    void setAddress(String address)
    {
        this.address = address;
    }

    void setPhoneNumber(long phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }

    double addCashback()
    {
        int cashback = (10 * (10 + (int)(Math.random() * 10)));
        this.walletBalance += cashback;
        System.out.println(green + "Congratulations! You received a cashback of " + def + cashback + "."+ green+ " Current wallet balance: " +def + this.walletBalance );
	return walletBalance;
    }

    void viewProfile()
    {
	System.out.println();
        System.out.println(purpe + "                User Details      " + def);
	System.out.println(yellow + "_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ " + def);
	System.out.println();
        System.out.println(skblue + "Name           : " + def + this.name);
        System.out.println(skblue + "Address        : " + def  + this.address);
        System.out.println(skblue + "Phone Number   : " + def  + this.phoneNumber);
        System.out.println(skblue + "Email ID       : " + def  + this.emailId);
        System.out.println(skblue + "Wallet Balance : " + def  + this.walletBalance);
	System.out.println(yellow + "_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ " + def);
    }


    void editProfile()
    {
	System.out.println();
        System.out.println(purpe + "                Edit Profile      " + def);
	System.out.println(yellow + "_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ " + def);
	System.out.println();
        System.out.println(skblue + "1. Edit Name" + def );
        System.out.println(skblue + "2. Edit Address" + def );
        System.out.println(skblue + "3. Edit Phone Number" + def );
        System.out.println(skblue + "4. Edit Email ID" + def );
	System.out.println(yellow + "_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ " + def);
	System.out.print("Enter your option: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice)
        {
            case 1:
                System.out.print(blue + "Enter new name: " + def);
                this.name = sc.nextLine();
                break;
            case 2:
                System.out.print(blue + "Enter new address: " + def);
                this.address = sc.nextLine();
                break;
            case 3:
                System.out.print(blue + "Enter new phone number: " + def);
                this.phoneNumber = sc.nextLong();
                break;
            case 4:
                boolean b = true;
		while (b) 
		{
			System.out.print(blue + "Enter new email ID: " + def);
    			String s = sc.next();
    			if (s.endsWith("@gmail.com")) 
			{
        			this.emailId = s;
        			b = false;
    			} 
			else 
			{
        			System.out.println(red + "Invalid EmailID. Please enter a valid Email ID ending with" + def + " @gmail.com ");
    			}
		}
                break;
            default:
                System.out.println(red + "Invalid choice!" + def);
        }
        System.out.println(green + "Profile updated successfully!"  + def);
    }
}


class City extends Colours
{
    static Scanner sc = new Scanner(System.in);
    private String cityName;
    private String area;

    void setCityName(String cityName)
    {
        this.cityName = cityName;
    }
    void setArea(String area)
    {
        this.area = area;
    }
    String getCityName()
    {
        return cityName;
    }
    String getArea()
    {
        return area;
    }
    void cityDisplay()
    {
	System.out.println();
	System.out.println(blue + "Select the City" + def);
        System.out.println(yellow + "1.Hyderabad" + def);
        System.out.println(yellow + "2.Vijayawada" + def);
        System.out.println(yellow + "3.Vizag" + def);
        String a = "Hyderabad";
        String b = "Vijayawada";
        String c = "Vizag";
	System.out.print("Enter the option: ");
        int n = sc.nextInt();
        switch(n)
        {
            case 1:
                setCityName(a);
                System.out.print(green + "Welcome to : "+ def);
                System.out.println(getCityName());
                areaDisplay();
                break;
            case 2:
                setCityName(b);
                System.out.print(green + "Welcome to : "+ def);
                System.out.println(getCityName());
                break;
            case 3:
                setCityName(c);
                System.out.print(green + "Welcome to : "+ def);
                System.out.println(getCityName());
                break;
        }

    }
    void areaDisplay()
    {
	System.out.println();
	System.out.println(blue + "Select the Area " + def);
        System.out.println(yellow + "1.Kphb" + def);
        System.out.println(yellow + "2.sr nagar" + def);
        System.out.println(yellow + "3.ammerpet" + def);
        String a = "Kphb";
        String b = "sr nagar";
        String c = "ammerpet";
	System.out.print("Enter the option: ");
        int k = sc.nextInt();
        switch(k)
        {
            case 1:
                setArea(a);
                System.out.print(green + "Welcome to : " + def);
                System.out.println(getArea());
                break;
            case 2:
                setArea(b);
                System.out.print(green + "Welcome to : " + def);
                System.out.println(getArea());
                break;
            case 3:
                setArea(c);
                System.out.print(green + "Welcome to : " + def);
                System.out.println(getArea());
                break;
        }

    }

}
class Menspg extends Colours {
    static Scanner sc = new Scanner(System.in);
    static String Pgname1 = "Shiva Sai";
    static String Ratings1 = "***";
    static String Address1 = "Road Number 2";
    static String cost1 = "1share = 7000, 2share = 6500, 3share = 6000";

    static String Pgname2 = "Rama Sai";
    static String Ratings2 = "****";
    static String Address2 = "Road Number 3";
    static String cost2 = "1share = 7000, 2share = 6500, 3share = 6000";

    static String Pgname3 = "Bhuvan Sai";
    static String Ratings3 = "*****";
    static String Address3 = "Road Number 3";
    static String cost3 = "1share = 7000, 2share = 6500, 3share = 6000";

    void displayShivaSai() {
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);
	System.out.println();
        System.out.println(green + "Welcome to Shiva Sai PG. Details are given below: "  + def);
        System.out.println(skblue + "Name    : " + def + Pgname1);
        System.out.println(skblue + "Address : " + def + Address1);
        System.out.println(skblue + "Cost    : " + def + cost1);
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);

    }

    void displayRamaSai() {
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);
	System.out.println();
        System.out.println(green + "Welcome to Rama Sai PG. Details are given below: " + def);
        System.out.println(skblue + "Name    : " + def + Pgname2);
        System.out.println(skblue + "Address : " + def + Address2);
        System.out.println(skblue + "Cost    : " + def + cost2);
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);

    }

    void displayBhuvanSai() {
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);
	System.out.println();
        System.out.println(green + "Welcome to Bhuvan Sai PG. Details are given below: " + def);
        System.out.println(skblue + "Name    : " + def + Pgname3);
        System.out.println(skblue + "Address : " + def + Address3);
        System.out.println(skblue + "Cost    : " + def + cost3);
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);

    }

    // Facility There providing.
    // Get Owner Detailes.

    void displayMenu()
    {
        System.out.println("Choose your preferred type of PG by entering the number next to your choice: ");
        System.out.println("1. Shiva Sai");
        System.out.println("2. Rama Sai");
        System.out.println("3. Bhuvan Sai");
	System.out.print("Enter the option: ");
        int n = sc.nextInt();
        if (n == 1)
        {
            displayShivaSai();
        }
        else if (n == 2)
        {
            displayRamaSai();
        }
        else if (n == 3)
        {
            displayBhuvanSai();
        }
        else
        {
            System.out.println(red + "Invalid selection."+ def);
        }
    }

    void displayAllPGs() {
	System.out.println();
	System.out.println(blue + "Details of all available PGs:" + def);
	System.out.println(yellow + "-----------------------------------------------------" + def);
	System.out.println();

        System.out.println(skblue + "Name    : " + def + Pgname1);
        System.out.println(skblue + "Ratings : " + def + Ratings1);
        System.out.println(skblue + "Address : " + def + Address1);
        System.out.println(skblue + "Cost    : " + def + cost1);

        System.out.println(skblue + "\nName  : " + def + Pgname2);
        System.out.println(skblue + "Ratings : " + def + Ratings2);
        System.out.println(skblue + "Address : " + def + Address2);
        System.out.println(skblue + "Cost    : " + def + cost2);

        System.out.println(skblue + "\nName  : " + def + Pgname3);
        System.out.println(skblue + "Ratings : " + def + Ratings3);
        System.out.println(skblue + "Address : " + def + Address3);
        System.out.println(skblue + "Cost    : " + def + cost3);

	System.out.println();
	System.out.println(yellow + "-----------------------------------------------------" + def);
	System.out.println();

        System.out.println("To proceed with booking, enter '1': ");
	System.out.print("Enter your Option :");
        int m = sc.nextInt();
        if (m == 1) {
            displayMenu();
        }
    }

    Menspg()
    {
        System.out.println("Welcome! Here you'll find a list of all available PG options. You can:");
        System.out.println("Press '1' to view the details of all PGs.");
        System.out.println("Press '2' to skip the details and select a PG directly.");
	System.out.print("Enter your Option :");
	int l = sc.nextInt();
	System.out.println();
     
        if (l == 1) {
            displayAllPGs();
        } else if (l == 2) {
            displayMenu();
        } else {
            System.out.println(red + "Invalid input." + def);
        }

    }
}
class Womenspg extends Colours {
    static Scanner sc = new Scanner(System.in);
    static String Pgname1 = "Anjali ";
    static String Ratings1 = "***";
    static String Address1 = "Road Number 2";
    static String cost1 = "1share = 6000, 2share = 5000, 3share = 450000";

    static String Pgname2 = "Swapna Raj";
    static String Ratings2 = "*****";
    static String Address2 = "Road Number 3";
    static String cost2 = "1share = 6000, 2share = 5000, 3share = 450000";

    static String Pgname3 = "Prutvi Raj Sai";
    static String Ratings3 = "***";
    static String Address3 = "Road Number 3";
    static String cost3 = "1share = 6000, 2share = 5000, 3share = 450000";

    void displayAnjali() {
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);
	System.out.println();
        System.out.println(green + "Welcome to Anjali PG. Details are given below:" + def);
        System.out.println(skblue + "Name    : " + def + Pgname1);
        System.out.println(skblue + "Address : " + def + Address1);
        System.out.println(skblue + "Cost    : " + def + cost1);
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);
    }

    void displaySwapna() {
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);
	System.out.println();
        System.out.println(green + "Welcome to Swapna Raj PG. Details are given below:" + def);
        System.out.println(skblue + "Name    : " + def + Pgname2);
        System.out.println(skblue + "Address : " + def + Address2);
        System.out.println(skblue + "Cost    : " + def + cost2);
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);
    }

    void displayPrutvi() {
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);
	System.out.println();
        System.out.println(green + "Welcome to Prutvi Raj PG. Details are given below:" + def);
        System.out.println(skblue + "Name    : " + def + Pgname3);
        System.out.println(skblue + "Address : " + def + Address3);
        System.out.println(skblue + "Cost    : " + def + cost3);
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);
    }

    // Facility There providing.
    // Get Owner Detailes.

    void displayMenu()
    {
        System.out.println("Choose your preferred type of PG by entering the number next to your choice: ");
        System.out.println("1. Anjali");
        System.out.println("2. Swapna Raj");
        System.out.println("3. Prutvi Raj");
	System.out.print("Enter your Option: ");
        int n = sc.nextInt();
        if (n == 1)
        {
            displayAnjali();
        }
        else if (n == 2)
        {
            displaySwapna();
        }
        else if (n == 3)
        {
            displayPrutvi();
        }
        else
        {
            System.out.println(red + "Invalid selection." + def);
        }
    }

    void displayAllPGs() {
        System.out.println();
	System.out.println(blue + "Details of all available PGs:" + def);
	System.out.println(yellow + "-----------------------------------------------------" + def);
	System.out.println();

        System.out.println(skblue + "Name    : "+ def + Pgname1);
        System.out.println(skblue + "Ratings : "+ def + Ratings1);
        System.out.println(skblue + "Address : "+ def + Address1);
        System.out.println(skblue + "Cost    : "+ def + cost1);

        System.out.println(skblue + "\nName  : "+ def + Pgname2);
        System.out.println(skblue + "Ratings : "+ def + Ratings2);
        System.out.println(skblue + "Address : "+ def + Address2);
        System.out.println(skblue + "Cost    : "+ def + cost2);

        System.out.println(skblue + "\nName  : " + def + Pgname3);
        System.out.println(skblue + "Ratings : " + def + Ratings3);
        System.out.println(skblue + "Address : " + def + Address3);
        System.out.println(skblue + "Cost    : " + def + cost3);

	System.out.println();
	System.out.println(yellow + "-----------------------------------------------------" + def);
	System.out.println();

        System.out.println("To proceed with booking, enter '1': ");
	System.out.print("Enter your Option : ");
        int m = sc.nextInt();
        if (m == 1) {
            displayMenu();
        }
    }

    Womenspg()
    {
        System.out.println("Welcome! Here you'll find a list of all available PG options. You can:");
        System.out.println("Press '1' to view the details of all PGs.");
        System.out.println("Press '2' to skip the details and select a PG directly.");
	System.out.print("Enter your Option : ");
        int l = sc.nextInt();
	System.out.println();
        if (l == 1) {
            displayAllPGs();
        } else if (l == 2) {
            displayMenu();
        } else {
            System.out.println(red + "Invalid input."+ def);
        }

    }
}
class Colivingpg extends Colours {
    static Scanner sc = new Scanner(System.in);
    static String Pgname1 = "Lia heights";
    static String Ratings1 = "***";
    static String Address1 = "Road Number 2";
    static String cost1 = "1share = 12000, 2share = 15000, 3share = 10000";

    static String Pgname2 = "Ramgopal varma";
    static String Ratings2 = "****";
    static String Address2 = "Road Number 3";
    static String cost2 = "1share = 12000, 2share = 15000, 3share = 10000";

    static String Pgname3 = "Loknath";
    static String Ratings3 = "*****";
    static String Address3 = "Road Number 3";
    static String cost3 = "1share = 12000, 2share = 15000, 3share = 10000";

    void displayLia() {
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);
	System.out.println();
        System.out.println(green + "Welcome to Lia heights PG. Details are given below:" + def);
        System.out.println(skblue + "Name    : " + def + Pgname1);
        System.out.println(skblue + "Address : " + def + Address1);
        System.out.println(skblue + "Cost    : " + def + cost1);
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);
    }

    void displayRam() {
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);
	System.out.println();
        System.out.println("Welcome to Ramgopal Varma PG. Details are given below:" + def);
        System.out.println("Name    : " + def + Pgname2);
        System.out.println("Address : " + def + Address2);
        System.out.println("Cost    : " + def + cost2);
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);
    }

    void displayLok() {
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);
	System.out.println();
        System.out.println("Welcome to Loknath PG. Details are given below:" + def);
        System.out.println("Name    : " + def + Pgname3);
        System.out.println("Address : " + def + Address3);
        System.out.println("Cost    : " + def + cost3);
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------" + def);
    }

    // Facility There providing.
    // Get Owner Detailes.

    void displayMenu()
    {
        System.out.println("Choose your preferred type of PG by entering the number next to your choice: ");
        System.out.println("1. Lia heights");
        System.out.println("2. Ramgopal Varma");
        System.out.println("3. Loknath");
	System.out.print("Enter your Option: ");
        int n = sc.nextInt();
	System.out.println();
        if (n == 1)
        {
            displayLia();
        }
        else if (n == 2)
        {
            displayRam();
        }
        else if (n == 3)
        {
            displayLok();
        }
        else
        {
            System.out.println(red + "Invalid selection." + def);
        }
    }

    void displayAllPGs() {
        System.out.println();
	System.out.println(blue + "Details of all available PGs:" + def);
	System.out.println(yellow + "-----------------------------------------------------" + def);
	System.out.println();

        System.out.println(skblue + "Name    : " + def + Pgname1);
        System.out.println(skblue + "Ratings : " + def + Ratings1);
        System.out.println(skblue + "Address : " + def + Address1);
        System.out.println(skblue + "Cost    : " + def + cost1);

        System.out.println(skblue + "\nName  : " + def + Pgname2);
        System.out.println(skblue + "Ratings : " + def + Ratings2);
        System.out.println(skblue + "Address : " + def + Address2);
        System.out.println(skblue + "Cost    : " + def + cost2);

        System.out.println(skblue + "\nName  : " + def + Pgname3);
        System.out.println(skblue + "Ratings : " + def + Ratings3);
        System.out.println(skblue + "Address : " + def + Address3);
        System.out.println(skblue + "Cost    : " + def + cost3);

        System.out.println();
	System.out.println(yellow + "-----------------------------------------------------" + def);
	System.out.println();

        System.out.println("To proceed with booking, enter '1': ");
	System.out.print("Enter your Option : ");
        int m = sc.nextInt();
	System.out.println();
        if (m == 1) {
            displayMenu();
        }
    }

    Colivingpg()
    {
        System.out.println("Welcome! Here you'll find a list of all available PG options. You can:");
        System.out.println("Press '1' to view the details of all PGs.");
        System.out.println("Press '2' to skip the details and select a PG directly.");
	System.out.print("Enter your Option : ");
        int l = sc.nextInt();
	System.out.println();
        if (l == 1) {
            displayAllPGs();
        } else if (l == 2) {
            displayMenu();
        } else {
            System.out.println(red + "Invalid input." + def);
        }

    }
}

class Hospital extends Colours
{

    private String name;
    private String location;
    private String address;
    private String distance;
    private String timings;

    Hospital(String name, String location, String address, String distance, String timings)
    {
        this.name = name;
        this.location = location;
        this.address = address;
        this.distance = distance;
        this.timings = timings;
    }

    void displayInfo()
    {
        System.out.println(yellow + "----------------------------------" + def);
        System.out.println();
        System.out.println(skblue + "Hospital Name : " + def + name);
        System.out.println(skblue + "Location      : " + def + location);
        System.out.println(skblue + "Address       : " + def + address);
        System.out.println(skblue + "Distance      : " + def + distance);
        System.out.println(skblue + "Timings       : " + def + timings);
        System.out.println();
        System.out.println(yellow + "----------------------------------" + def);
    }
}

class RestaurantsKPHB extends Colours {
    static Scanner sc = new Scanner(System.in);

    static String restaurantName1 = "Hunger's Choice Multicuisine Restaurant";
    static String ratings1 = "4.4 stars";
    static String address1 = "MIG-415, KPHB, Road, NO- 4, Remedy Hospital Ln, Hyderabad, Telangana 500072";
    static String costForTwo1 = "Approximately Rs. 200 - 500.per person - North Indian restaurant";

    static String restaurantName2 = "Babai Hotel";
    static String ratings2 = "4.2 stars";
    static String address2 = "Rd Number 1, Kukatpally Housing Board Colony, Kukatpally, Hyderabad, Telangana 500072";
    static String costForTwo2 = "Approximately Rs.200 - 300 for person - Lunch restaurant";

    static String restaurantName3 = "Western restaurant and cafe";
    static String ratings3 = "4.3 stars";
    static String address3 = "PNR empire, Padmaraga Group of Hotels - PNR Empire, above Dadu's Sweets, Kukatpally";
    static String costForTwo3 = "Starts from Rs. 99/- and above - A family restaurant";

    void displayHungersChoice() {
	System.out.println();
	System.out.println(yellow + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " + def);
        System.out.println();
        System.out.println(green + "Welcome to Hungers Choice! Details are given below:"+ def);
        System.out.println(skblue + "Name            : "+ def + restaurantName1);
        System.out.println(skblue + "Ratings         : "+ def + ratings1);
        System.out.println(skblue + "Address         : "+ def + address1);
        System.out.println(skblue + "Cost for Person : "+ def + costForTwo1);
	System.out.println();
	System.out.println(yellow + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " + def);
	System.out.println();
        System.out.println("Looking For the Menu.Please press 1 to get menu");
	System.out.print("Enter the Number: ");
        int n = sc.nextInt();
        if(n == 1)
        {
            HungersChoiceMenu();
        }
        else
        {
            System.out.println(red + "Heyyy..! U Entered Wrong Number." + def);
        }
    }

    void HungersChoiceMenu() {
	System.out.println();
	System.out.println(yellow + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + def);
        System.out.println();
        System.out.println(purpe + "              ************ Menu ************"+ def);
        System.out.println();
        System.out.println(blue + "	Items					 Price	 	" + def);
        System.out.println();
        System.out.println(skblue + "1.Paneer Tikka                          -"+ def +"    	 Rs.250");
        System.out.println("Marinated cottage cheese grilled to perfection.");
        System.out.println();
        System.out.println(skblue + "2.Chicken Tandoori                      -"+ def +"	 Rs.300");
        System.out.println("Traditional Indian-style marinated chicken, slow-cooked in a clay oven.");
        System.out.println();
        System.out.println(skblue + "3.Veg Hakka Noodles                     -"+ def +"        Rs.180");
        System.out.println("Stir-fried noodles with vegetables and a blend of Indo-Chinese flavors.");
        System.out.println();
        System.out.println(skblue + "4.Butter Chicken                        -"+ def +"        Rs.320");
        System.out.println("Creamy, mildly spiced chicken curry in a buttery tomato sauce.");
        System.out.println();
        System.out.println(skblue + "5.Dal Makhani                           -"+ def +"        Rs.180");
        System.out.println("Rich, slow-cooked black lentils with cream and butter.");
        System.out.println();
        System.out.println(skblue + "6.Mutton Rogan Josh                     -"+ def +"        Rs.400");
        System.out.println("Aromatic lamb curry with spices from Kashmir.");
        System.out.println();
        System.out.println(skblue + "7.Paneer Butter Masala                  -"+ def +"        Rs.240");
        System.out.println("Soft paneer cubes in a creamy, tangy tomato-based gravy.");
        System.out.println();
        System.out.println(skblue + "8.Veg Biryani                           -"+ def +"        Rs.200");
        System.out.println("Flavored rice cooked with spices and mixed vegetables, served with raita.");
        System.out.println();
        System.out.println(skblue + "9.Chicken Biryani                       -"+ def +"        Rs.280");
        System.out.println("Aromatic rice with marinated chicken, layered with spices.");
        System.out.println();
        System.out.println(skblue + "10.Gulab Jamun                          -"+ def +"        Rs.80");
        System.out.println("Soft and sweet dumplings soaked in rose-flavored sugar syrup.");
        System.out.println();
	System.out.println(yellow + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + def);
        System.out.println();
    }

    void displayBabaiHotel() {
	System.out.println();
	System.out.println(yellow + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " + def);
        System.out.println();
        System.out.println(green + "Welcome to Veggie Delight! Details are given below: " + def);
        System.out.println(skblue + "Name            : " + def + restaurantName2);
        System.out.println(skblue + "Ratings         : " + def + ratings2);
        System.out.println(skblue + "Address         : " + def + address2);
        System.out.println(skblue + "Cost for Person : " + def + costForTwo2);
	System.out.println();
	System.out.println(yellow + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " + def);
        System.out.println();
        System.out.println("Looking For the Menu.Please press 1 to get menu");
	System.out.print("Enter the Number: ");
        int n = sc.nextInt();
        if(n == 1)
        {
            BabaiHotelMenu();
        }
        else
        {
            System.out.println(red + "Heyyy! U pressed Wrong button." + def);
        }
    }

    void BabaiHotelMenu() {
        System.out.println();
	System.out.println(yellow + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + def);
        System.out.println();
        System.out.println(purpe + "              ************ Menu ************"+ def);
        System.out.println();
        System.out.println(blue + "	Items					 Price	 	" + def);
        System.out.println();
        System.out.println(skblue + "1.Vegetable Meals                          -"+ def +"      Rs.150");
        System.out.println("A complete South Indian meal with rice, sambar, rasam, curry, pickle, papad, and curd.");
        System.out.println();
        System.out.println(skblue + "2.Podi Dosa                                -"+ def +"      Rs.60");
        System.out.println("Crispy dosa sprinkled with spicy lentil powder (podi) and served with chutney.");
        System.out.println();
        System.out.println(skblue + "3.Idli with Ghee & Karam                   -"+ def +"      Rs.50");
        System.out.println("Soft idlis topped with a dollop of ghee and spicy karam (chili powder).");
        System.out.println();
        System.out.println(skblue + "4.Vada                                     -"+ def +"      Rs.40");
        System.out.println("Crispy deep-fried lentil fritters, served with sambar and coconut chutney.");
        System.out.println();
        System.out.println(skblue + "5.Sambar Rice                              -"+ def +"      Rs.70");
        System.out.println("Rice mixed with aromatic sambar, served with papad and pickle.");
        System.out.println();
        System.out.println(skblue + "6.Curd Rice                                -"+ def +"      Rs.50");
        System.out.println("Cool and refreshing rice mixed with fresh curd, served with pickle.");
        System.out.println();
        System.out.println(skblue + "7.Pulihora (Tamarind Rice)                 -"+ def +"      Rs.60");
        System.out.println("Tangy rice flavored with tamarind and spices, garnished with peanuts and curry leaves.");
        System.out.println();
        System.out.println(skblue + "8.Pesarattu                                -"+ def +"     Rs.70");
        System.out.println("Green gram dosa served with ginger chutney, a healthy and filling option.");
        System.out.println();
        System.out.println(skblue + "9.Chicken Biryani                          -"+ def +"     Rs.40");
        System.out.println("Savory semolina porridge cooked with vegetables and mild spices, served with chutney.");
        System.out.println();
        System.out.println(skblue + "10.Sweet Pongal                            -"+ def +"     Rs.30");
        System.out.println("A dessert made with rice, jaggery, and ghee, flavored with cardamom.");
        System.out.println();
	System.out.println(yellow + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + def);
        System.out.println();
    }

    void displayWesternRC() {
	System.out.println();
	System.out.println(yellow + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " + def);
        System.out.println();
        System.out.println(green + "Welcome to Grill & Chill! Details are given below: " + def);
        System.out.println(skblue + "Name            : " + def + restaurantName3);
        System.out.println(skblue + "Ratings         : " + def + ratings3);
        System.out.println(skblue + "Address         : " + def + address3);
        System.out.println(skblue + "Cost for Person : " + def + costForTwo3);
	System.out.println();
	System.out.println(yellow + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " + def);
        System.out.println();
        System.out.println("Looking For the Menu.Please press 1 to get menu");
        int n = sc.nextInt();
	System.out.print("Enter the Number: ");

        if(n == 1)
        {
            WesternRCMenu();
        }
        else
        {
            System.out.println("Heyyy! U pressed Wrong button.");
        }
    }

    void WesternRCMenu() {
        System.out.println();
	System.out.println(yellow + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + def);
        System.out.println();
        System.out.println(purpe + "              ************ Menu ************"+ def);
        System.out.println();
        System.out.println(blue + "	Items					 Price	 	" + def);
        System.out.println();
        System.out.println(skblue + "1.Margherita Pizza                          -"+ def +"      Rs.250");
        System.out.println("Classic pizza topped with mozzarella cheese, fresh tomatoes, and basil.");
        System.out.println();
        System.out.println(skblue + "2.Grilled Chicken Steak                     -"+ def +"      Rs.350");
        System.out.println("Juicy grilled chicken served with mashed potatoes, sautéed vegetables, and pepper sauce.");
        System.out.println();
        System.out.println(skblue + "3.Pasta Alfredo                             -"+ def +"      Rs.280");
        System.out.println("Creamy Alfredo pasta with a choice of penne or spaghetti, garnished with Parmesan cheese.");
        System.out.println();
        System.out.println(skblue + "4.Paneer Tikka Sandwich                     -"+ def +"      Rs.150");
        System.out.println("Grilled sandwich with spiced paneer, fresh vegetables, and mint chutney.");
        System.out.println();
        System.out.println(skblue + "5.Butter Naan with Paneer Butter Masala     -"+ def +"      Rs.220");
        System.out.println("Soft butter naan served with rich and creamy paneer butter masala.");
        System.out.println();
        System.out.println(skblue + "6.Cappuccino                                -"+ def +"      Rs.100");
        System.out.println("Traditional Indian spiced tea brewed with milk and aromatic spices.");
        System.out.println();
        System.out.println(skblue + "7.Masala Chai                               -"+ def +"      Rs.60");
        System.out.println("Traditional Indian spiced tea brewed with milk and aromatic spices.");
        System.out.println();
        System.out.println(skblue + "8.Virgin Mojito                             -"+ def +"     Rs.120");
        System.out.println("Refreshing mocktail with mint, lime, and soda. Perfect for a warm day.");
        System.out.println();
        System.out.println(skblue + "9.Cold Coffee                               -"+ def +"     Rs.90");
        System.out.println("Chilled coffee blended with milk, topped with whipped cream.");
        System.out.println();
        System.out.println(skblue + "10.Chocolate Brownie with Ice Cream         -"+ def +"     Rs.100");
        System.out.println("Warm chocolate brownie served with a scoop of vanilla ice cream.");
        System.out.println();
	System.out.println(yellow + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + def);
        System.out.println();
    }


    void display() {
        System.out.println("Select a restaurant to view details. Enter the corresponding number:  ");
        System.out.println("1. Hunger's Choice Multicuisine Restaurant");
        System.out.println("2. Babai Hotel");
        System.out.println("3. Western restaurant and cafe");
	System.out.print("Enter Your choice: ");
        int choice = sc.nextInt();
	System.out.println();

        if (choice == 1) {
            displayHungersChoice();
        } else if (choice == 2) {
            displayBabaiHotel();
        } else if (choice == 3) {
            displayWesternRC();
        } else {
            System.out.println(red + "Invalid selection. Please choose a valid restaurant." + def);
        }
    }

    void displayAllRestaurants() {
        System.out.println(blue + "Details of all available restaurants:" + def);
	System.out.println(yellow + "--------------------------------------------------------------------------------" + def);
	System.out.println();

        System.out.println(skblue + "Name            : " + def + restaurantName1);
        System.out.println(skblue + "Ratings         : " + def + ratings1);
        System.out.println(skblue + "Address         : " + def + address1);
        System.out.println(skblue + "Cost for Person : " + def + costForTwo1);

        System.out.println(skblue + "\nName           : " + def + restaurantName2);
        System.out.println(skblue + "Ratings         : " + def + ratings2);
        System.out.println(skblue + "Address         : " + def + address2);
        System.out.println(skblue + "Cost for Person : " + def + costForTwo2);

        System.out.println(skblue + "\nName           : " + def + restaurantName3);
        System.out.println(skblue + "Ratings         : " + def + ratings3);
        System.out.println(skblue + "Address         : " + def + address3);
        System.out.println(skblue + "Cost for Person : " + def + costForTwo3);
	System.out.println();
	System.out.println(yellow + "--------------------------------------------------------------------------------" + def);
	System.out.println();

        System.out.println("To proceed with viewing details of a specific restaurant, enter '1': ");
	System.out.print("Enter the Number: ");
        int proceed = sc.nextInt();
        if (proceed == 1) {
            display();
        }
    }
}

class Place extends Colours
{
    static Scanner sc = new Scanner(System.in);
    private String name;
    private String description;
    private String address;
    private double entryFee;

    Place(String name, String description, String address, double entryFee)
    {
        this.name = name;
        this.description = description;
        this.address = address;
        this.entryFee = entryFee;
    }

    String getName()
    {
        return name;
    }

    String getDescription()
    {
        return description;
    }

    String getAddress()
    {
        return address;
    }

    public double getEntryFee() {
        return entryFee;
    }

    void displayInfo()
    {
	System.out.println(yellow + "--------------------------------------------------------------------------------" + def);
	System.out.println();
        System.out.println(skblue + "Name        : "+ def + name);
        System.out.println(skblue + "Description : "+ def + description);
        System.out.println(skblue + "Address     : "+ def + address);
        System.out.println(skblue + "Entry Fee   : "+ def +"Rs "+ entryFee);
    }
}
class A extends Colours
{
    static Scanner sc = new Scanner(System.in);
    void m4()
    {
        System.out.println(green + "            Thank You for visiting our App :)             " + def);
    }
    void m2()
    {
	System.out.println();
        System.out.println(blue + "Here are the available places in this area:" + def);
        System.out.println(skblue + "1.pg" + def);
        System.out.println(skblue + "2.hospital" + def);
        System.out.println(skblue + "3.Restarent" + def);
        System.out.println(skblue + "4.Famous place" + def);
        //A obj1=new A();
	System.out.print("Enter your option: ");
        int Z=sc.nextInt();
	System.out.println();
        if(Z==1)
        {
	    System.out.println();
            System.out.println(blue + "which pg would u like to prefer" + def);
            System.out.println(skblue + "1.menspg" + def);
	    System.out.println(skblue + "2.womenspg" + def);
	    System.out.println(skblue + "3.colivingpg" + def);
	    System.out.print("Enter your option: ");
            int G=sc.nextInt();
	    System.out.println();
            if(G==1)
            {
                Menspg menspg = new Menspg();
                System.out.println(purpe + "Are u willing to go back are want to exit the app" + def);
                System.out.println("1.go back");
                System.out.println("2.exit");
		System.out.print("Enter your option: ");
                int x=sc.nextInt();
                if(x==1)
                {
                    m3();
                }
                else if(x==2)
                {
                    m4();
                }
            }
            else if(G==2)
            {
                Womenspg Wmenspg = new Womenspg();
                System.out.println(purpe + "Are u willing to go back are want to exit the app" + def);
                System.out.println("1.go back");
                System.out.println("2.exit");
		System.out.print("Enter your option: ");
                int x=sc.nextInt();
                if(x==1)
                {
                    m3();
                }
                else if(x==2)
                {
                    m4();
                }
            }
            else if(G==3)
            {
                Colivingpg Cospg = new Colivingpg();
                System.out.println(purpe + "Are u willing to go back are want to exit the app" + def);
                System.out.println("1.go back");
                System.out.println("2.exit");
		System.out.print("Enter your option: ");
                int x=sc.nextInt();
                if(x==1)
                {
                    m3();
                }
                else if(x==2)
                {
                    m4();
                }

            }
        }
        else if(Z==2)
        {
            System.out.println(blue + "Choose a hospital to view details:" + def);
            Hospital Hp1 = new Hospital("Remedy Hospital","KPHB","Road No.4,KPHB,Kukatpally","1 KM", "24/7");
            Hospital Hp2 = new Hospital("Ramdev Rao Hospital","KPHB","Metro pillar no 34,NH-65,Kukatpally","1.8km","24/7");
            Hospital Hp3 = new Hospital("Omni Hospital","Kukatpally","Rd Number 1","1.5km","24/7");
            System.out.println(skblue + "1.Remedy Hospital" + def);
            System.out.println(skblue + "2.Ramdev Rao Hospital" + def);
            System.out.println(skblue + "3.Omni Hospital" + def);
	    System.out.print("Enter your Option: ");
            int n = sc.nextInt();
	    System.out.println();
            switch(n)
            {
                case 1:
                    System.out.println("\nYou selected Remedy Hospital.");
                    Hp1.displayInfo();
                    break;

                case 2:
                    System.out.println("\nYou selected Ramdev Rao Hospital.");
                    Hp2.displayInfo();
                    break;

                case 3:
                    System.out.println("\nYou selected Omni Hospital.");
                    Hp3.displayInfo();
                    break;

                case 4:
                    System.out.println("\nGoing back to main menu...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println(purpe + "Are u willing to go back are want to exit the app" + def);
            System.out.println("1.go back");
            System.out.println("2.exit");
            int y=sc.nextInt();
            if(y==1)
            {
                m3();
            }
            else if(y==2)
            {
                m4();
            }
        }
        else if(Z==3)
        {
            RestaurantsKPHB Rk = new RestaurantsKPHB();
            System.out.println("Welcome to the Restaurants page! Here you can view details of popular restaurants in the area.");
            System.out.println("Press 1 to display all restaurant details.");
            System.out.println("Press 2 to skip details and select a restaurant directly.");
	    System.out.print("Choose Your Option: ");
            int selection = sc.nextInt();
	    System.out.println();

            if (selection == 1) {
                Rk.displayAllRestaurants();
            } else if (selection == 2) {
                Rk.display();
            } else {
                System.out.println(red + "Invalid Input. Please start the program again." + def);
            }
            System.out.println(purpe + "Are u willing to go back are want to exit the app" + def);
            System.out.println("1.go back");
            System.out.println("2.exit");
            int v=sc.nextInt();
            if(v==1)
            {
                m3();
            }
            else if(v==2)
            {
                m4();
            }
        }
        else if(Z==4)
        {
            Place p1 = new Place("Charminar", "Historical monument and mosque", "Charminar, Hyderabad", 0.0);
            Place p2 = new Place("Golconda Fort", "Historic fort with panoramic views", "Golconda, Hyderabad", 100.0);
            Place p3 = new Place("Hussain Sagar", "Beautiful lake with a large Buddha statue", "Tank Bund Road, Hyderabad", 200.0);
            Place p4 = new Place("Ramoji Film City", "World's largest film city", "Ramoji, Hyderabad", 50.0);

            System.out.println(green + "Welcome to the Famous Places in Hydarabad" + def);
            boolean exit = false;

            if(exit == false)
            {
                System.out.println();
                System.out.println("1. Display All Famous Places");
               // System.out.println("2. Search for a Place by Name");
                System.out.println("2. Exit");
                System.out.println();
                System.out.print("Enter your choice: ");
                int m = Place.sc.nextInt();
                System.out.println();

                switch(m)
                {
                    case 1:
                        System.out.println(blue + "List of Famous Places: " + def);
                        p1.displayInfo();
                        System.out.println();
                        p2.displayInfo();
                        System.out.println();
                        p3.displayInfo();
                        System.out.println();
                        p4.displayInfo();
                        System.out.println();
			System.out.println();
			System.out.println(yellow + "--------------------------------------------------------------------------------" + def);
                        break;

                   // case 2:
                   //     System.out.print("Enter the name of the place to search: ");
                   //     String placeName = Place.sc.nextLine();
                        // famousPlaces.searchPlace(placeName);
                   //     break;

                    case 2:
                        exit = true;
                        System.out.println(purpe + "Exiting the Famous Places Module." + def);
                        break;

                    default:
                        System.out.println(red + "Invalid choice. Please try again." + def);
                }

            }
            System.out.println(purpe + "Are u willing to go back are want to exit the app" + def);
            System.out.println("1.go back");
            System.out.println("2.exit");
            int W=sc.nextInt();
            if(W==1)
            {
                m3();
            }
            else if(W==2)
            {
                m4();
            }
        }
    }
    void m3()
    {
	System.out.println();
        System.out.println(blue + "Here are the available places in this area:" + def);
        System.out.println(skblue + "1.pg" + def);
        System.out.println(skblue + "2.hospital" + def);
        System.out.println(skblue + "3.Restarent" + def);
        System.out.println(skblue + "4.Famous place" + def);
        //A obj1=new A();
	System.out.print("Enter your option: ");
        int Z=sc.nextInt();
	System.out.println();
        if(Z==1)
        {
            System.out.println();
            System.out.println(blue + "which pg would u like to prefer" + def);
            System.out.println(skblue + "1.menspg" + def);
	    System.out.println(skblue + "2.womenspg" + def);
	    System.out.println(skblue + "3.colivingpg" + def);
	    System.out.print("Enter your option: ");
            int Q=sc.nextInt();
	    System.out.println();
            if(Q==1)
            {
                Menspg menspg = new Menspg();
                System.out.println(purpe + "Are u willing to go back are want to exit the app" + def);
                System.out.println("1.go back");
                System.out.println("2.exit");
		System.out.print("Enter your option: ");
                int x=sc.nextInt();
                if(x==1)
                {
                    m2();
                }
                else if(x==2)
                {
                    m4();
                }
            }
            else if(Q==2)
            {
                Womenspg Wmenspg = new Womenspg();
                System.out.println(purpe + "Are u willing to go back are want to exit the app" + def);
                System.out.println("1.go back");
                System.out.println("2.exit");
		System.out.print("Enter your option: ");
                int x=sc.nextInt();
                if(x==1)
                {
                    m2();
                }
                else if(x==2)
                {
                    m4();
                }
            }
            else if(Q==3)
            {
                Colivingpg Cospg = new Colivingpg();
                System.out.println(purpe + "Are u willing to go back are want to exit the app" + def);
                System.out.println("1.go back");
                System.out.println("2.exit");
		System.out.print("Enter your option: ");
                int x=sc.nextInt();
                if(x==1)
                {
                    m2();
                }
                else if(x==2)
                {
                    m4();
                }
            }
        }
        else if(Z==2)
        {
            System.out.println(blue + "Choose a hospital to view details:" + def);
            Hospital Hp1 = new Hospital("Remedy Hospital","KPHB","Road No.4,KPHB,Kukatpally","1 KM", "24/7");
            Hospital Hp2 = new Hospital("Ramdev Rao Hospital","KPHB","Metro pillar no 34,NH-65,Kukatpally","1.8km","24/7");
            Hospital Hp3 = new Hospital("Omni Hospital","Kukatpally","Rd Number 1","1.5km","24/7");
            System.out.println(skblue + "1.Remedy Hospital" + def);
            System.out.println(skblue + "2.Ramdev Rao Hospital" + def);
            System.out.println(skblue + "3.Omni Hospital" + def);
	    System.out.print("Enter your Option: ");
            int n = sc.nextInt();
	    System.out.println();

            switch(n)
            {
                case 1:
                    System.out.println("\nYou selected Remedy Hospital.");
                    Hp1.displayInfo();
                    break;

                case 2:
                    System.out.println("\nYou selected Ramdev Rao Hospital.");
                    Hp2.displayInfo();
                    break;

                case 3:
                    System.out.println("\nYou selected Omni Hospital.");
                    Hp3.displayInfo();
                    break;

                case 4:
                    System.out.println("\nGoing back to main menu...");
                    return;

                default:
                    System.out.println(red + "Invalid choice. Please try again." + def);
                    break;
            }
            System.out.println(purpe + "Are u willing to go back are want to exit the app" + def);
            System.out.println("1.go back");
            System.out.println("2.exit");
	    System.out.print("Enter your option: ");
            int y=sc.nextInt();
            if(y==1)
            {
                m2();
            }
            else if(y==2)
            {
                m4();
            }
        }
        else if(Z==3)
        {
            RestaurantsKPHB Rk = new RestaurantsKPHB();
            System.out.println("Welcome to the Restaurants page! Here you can view details of popular restaurants in the area.");
            System.out.println("Press 1 to display all restaurant details.");
            System.out.println("Press 2 to skip details and select a restaurant directly.");
	    System.out.print("Choose Your Option: ");
            int selection = sc.nextInt();
	    System.out.println();


            if (selection == 1) {
                Rk.displayAllRestaurants();
            } else if (selection == 2) {
                Rk.display();
            } else {
                System.out.println(red + "Invalid input. Please start the program again." + def);
            }
            System.out.println(purpe + "Are u willing to go back are want to exit the app"+ def);
            System.out.println("1.go back");
            System.out.println("2.exit");
            int v=sc.nextInt();
            if(v==1)
            {
                m2();
            }
            else if(v==2)
            {
                m4();
            }
        }
        else if(Z==4)
        {
            Place p1 = new Place("Charminar", "Historical monument and mosque", "Charminar, Hyderabad", 0.0);
            Place p2 = new Place("Golconda Fort", "Historic fort with panoramic views", "Golconda, Hyderabad", 100.0);
            Place p3 = new Place("Hussain Sagar", "Beautiful lake with a large Buddha statue", "Tank Bund Road, Hyderabad", 200.0);
            Place p4 = new Place("Ramoji Film City", "World's largest film city", "Ramoji, Hyderabad", 50.0);

            System.out.println(green + "Welcome to the Famous Places in Hydarabad" + def);
            boolean exit = false;

            if(exit == false)
            {
                System.out.println();
                System.out.println("1. Display All Famous Places");
               // System.out.println("2. Search for a Place by Name");
                System.out.println("2. Exit");
                System.out.println();
                System.out.print("Enter your choice: ");
                int m = Place.sc.nextInt();
                System.out.println();

                switch(m)
                {
                    case 1:
                        System.out.println(blue + "List of Famous Places:" + def);
                        p1.displayInfo();
                        System.out.println();
                        p2.displayInfo();
                        System.out.println();
                        p3.displayInfo();
                        System.out.println();
                        p4.displayInfo();
                        System.out.println();
			System.out.println();
			System.out.println(yellow + "--------------------------------------------------------------------------------" + def);
                        break;

                   // case 2:
                   //     System.out.print("Enter the name of the place to search: ");
                   //     String placeName = Place.sc.nextLine();
                        // famousPlaces.searchPlace(placeName);
                   //     break;

                    case 2:
                        exit = true;
                        System.out.println(purpe + "Exiting the Famous Places Module." + def);
                        break;

                    default:
                        System.out.println(red + "Invalid choice. Please try again." + def);
                }

            }
            System.out.println(purpe + "Are u willing to go back are want to exit the app" + def);
            System.out.println("1.go back");
            System.out.println("2.exit");
            int W=sc.nextInt();
            if(W==1)
            {
                m2();
            }
            else if(W==2)
            {
                m4();
            }
        }
    }


}
class SmartCity 
{
    static final String def = "\u001b[0;1m";
    static final String blink = "\u001b[5m";
    static final String red =  "\u001b[31;1m";
    static final String green = "\u001b[32;1m";
    static final String yellow = "\u001b[33;1m";
    static final String blue = "\u001b[34;1m";
    static final String purpe = "\u001b[35;1m";
    static final String skblue = "\u001b[36;1m";
    static final String bgred =  "\u001b[101;1m";
    static final String bggreen = "\u001b[102;1m";
    static final String bgyellow = "\u001b[103;1m";
    static final String bgblue = "\u001b[104;1m";
    static final String bgpurpe = "\u001b[105;1m";
    static final String bgskblue = "\u001b[106;1m";
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
	System.out.println();
	System.out.println(blink + green + "********************************************************" + def);
	System.out.println(blink + green + "*                                                      *" + def);
	System.out.println(blink + green + "*               " + def + blue + "SMART CITY APP" + def + blink + green + "                         *" + def);
	System.out.println(blink + green + "*                                                      *" + def);
	System.out.println(blink + green + "********************************************************" + def);
	
	System.out.println();
        System.out.println(skblue + "   ___________*WELCOME TO THE LOGIN PAGE*___________   " + def);
	System.out.println();
        System.out.println("Login with PhoneNumber");


	Profile userProfile = new Profile();
	System.out.println();
	
	System.out.println(yellow + "1. View Profile" + def);
	System.out.println(yellow + "2. Edit Profile" + def);
	System.out.print("Enter your option: ");
	int profileOption = sc.nextInt();

	if (profileOption == 1) {
    		userProfile.viewProfile();
    		boolean continueEditing = true;
	
    		while (continueEditing) {
        		System.out.println(green + "\nDo you want to update the profile?" + def);
        		System.out.println("1. Yes, update the profile");
        		System.out.println("2. Exit");

        		System.out.print("Enter your choice: ");
        		int choice = sc.nextInt();

        		if (choice == 1) {
            			userProfile.editProfile();
       			} else if (choice == 2) {
            			continueEditing = false;
            			System.out.println(blue + "Exiting profile menu..." + def);
				userProfile.viewProfile();
        		} else {
            			System.out.println(red + "Invalid choice! Please try again." + def);
        		}
    		}
	} else if (profileOption == 2) {
    		userProfile.editProfile();
		boolean continueEditing = true;
	
    		while (continueEditing) {
        		System.out.println(green + "\nDo you want to update the profile?" + def);
        		System.out.println("1. Yes, update the profile");
        		System.out.println("2. Exit");

        		System.out.print("Enter your choice: ");
        		int choice = sc.nextInt();

        		if (choice == 1) {
            			userProfile.editProfile();
       			} else if (choice == 2) {
            			continueEditing = false;
            			System.out.println(blue + "Exiting profile menu..." + def);
				userProfile.viewProfile();
        		} else {
            			System.out.println(red + "Invalid choice! Please try again." + def);
        		}
    		}

	} else {
    		System.out.println(red + "Invalid option! Please enter 1 or 2." + def);
	}

        City obj = new City();
        obj.cityDisplay();
        A obj1=new A();
        obj1.m2();
    }
}
