package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int raccoonsInWoods = 3;
		int raccoonsGoHome = 2;
		int raccoonsLeftInWoods = raccoonsInWoods - raccoonsGoHome;

        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int flowers = 5;
		int bees = 3;
		int differenceFlowersBees = flowers - bees;

        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int lonelyPigeon = 1;
		int anotherPigeon = 1;
		int totalPigeon = lonelyPigeon + anotherPigeon;

        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int owlsOnFence = 3;
		int owlsOtherJoinOnFence = 2;
		int totalOwlsOnFence = owlsOnFence + owlsOtherJoinOnFence;

        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int beaversWorkOnHome = 2;
		int beaversWentSwimming = 1;
		int totalBeaversWorkOnHome = beaversWorkOnHome - beaversWentSwimming;
		

        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int toucansSittingOnTree = 2;
		int toucansJoinsOnTree = 1;
		int totalToucansOnTree = toucansSittingOnTree + toucansJoinsOnTree;

        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int squirrels = 4;
		int nuts = 2;
		int differenceSquirrelsNuts = squirrels - nuts;

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		int quarterFound=1;
		int dimeFound=1;
		int nickelFound=2;
		double quarter = 0.25;
		double dime = 0.10;
		double nickel = 0.05;
		double totalMoney = (quarter*quarterFound)+(dime*dimeFound)+(nickel*nickelFound);
		System.out.print(totalMoney + " cents\n");

        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int classMrsBrierMuffins = 18;
		int classMrsMacAdamsMuffins = 20;
		int classMrsFlanneryMuffins = 17;
		int totalClassMuffins = classMrsBrierMuffins + classMrsMacAdamsMuffins + classMrsFlanneryMuffins;
		

        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		int yoyoSpent = 24;
		int whistleSpent = 14;
		int totalSpent = yoyoSpent + whistleSpent;

        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int largeMarshmallows = 8;
		int miniMarshmallows = 10;
		int totalMarshmallows = largeMarshmallows + miniMarshmallows;
		
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int snowAmountMrsHiltHouse = 29;
		int snowAmountBrecknockSchool = 17;
		int diffSnowAmountMrsHiltHouseBrecknockSchool = snowAmountMrsHiltHouse - snowAmountBrecknockSchool;
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		int totalMoneyMrsHilt = 10;
		int costToyTruck = 3;
		int costPencil = 2;
		int totalMoneyLeft = totalMoneyMrsHilt - costToyTruck - costPencil;
		//System.out.println(totalMoneyLeft);

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int marblesCollection = 16;
		int marblesLost = 7;
		int totalMarbles = marblesCollection - marblesLost;

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int totalSeashellsMeganHas = 19;
		int seashellsMeganNeed = 25 - totalSeashellsMeganHas;

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int totalBalloons = 17;
		int redBalloons = 8;
		int greenBalloons = totalBalloons - redBalloons;

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int booksOnShelf = 38;
		int booksMartaPut = 10;
		int totalBooks = booksOnShelf + booksMartaPut;

        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int legsOnBee = 6;
		int numberOfBees = 8;
		int totalNumberOfBeeLegs = legsOnBee * numberOfBees;
		
		
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double costOfIceCream = 0.99;
		int numberOfIceCream = 2;
		double totalCostIceCream = costOfIceCream * numberOfIceCream;
		System.out.println(totalCostIceCream);
		

        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int totalRocksToCompleteBorder = 125;
		int rocksHave = 64;
		int rocksNeedToCompleteBorder = totalRocksToCompleteBorder - rocksHave;
		
		
        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int totalMarblesHave = 38;
		int totalMarblesLost = 15;
		int marblesLeft = totalMarblesHave - totalMarblesLost;
		
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int totalMilesToConcert = 78;
		int milesDrove = 32;
		int milesLeftToDrive = totalMilesToConcert - milesDrove;

        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		int minutesSpentInMorning = 60+30;
		int minutesSpentInAfternoon = 45;
		int totalTimeSpent = minutesSpentInMorning + minutesSpentInAfternoon;

        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		int hotDogsBought = 6;
		double costOfEachHotDog = 0.50;
		double totalPaidForHotDogs = hotDogsBought * costOfEachHotDog;
		System.out.println(totalPaidForHotDogs);
		
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		double moneyHave = 0.50;
		double costOfPencil = 0.07;
		int numberOfPencilsCanBuy = (int)(moneyHave/costOfPencil);
		System.out.println(numberOfPencilsCanBuy);

        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int butterfliesSaw = 33;
		int orangeButterflies = 20;
		int redButterflies = butterfliesSaw - orangeButterflies;
		
		
        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double moneyGaveToClerk = 1.00;
		double costOfCandy = 0.54;
		double changeMoneyBack = moneyGaveToClerk - costOfCandy;
		System.out.println(changeMoneyBack);
		
		
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int treesInBackyard = 13;
		int treesPlanted = 12;
		int totalTrees = treesInBackyard + treesPlanted;
		

        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int daysJoySeeGrandma = 2;
		int hoursInADay = 24;
		int hoursJoyWillSeeGrandma = daysJoySeeGrandma * hoursInADay;

        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int numberOfCousinsKimHas = 4;
		int gumsKimWantGiveEachCousin = 5;
		int gumsKimNeed = numberOfCousinsKimHas * gumsKimWantGiveEachCousin;

        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double moneyDanHas = 3.00;
		double costOfCandyBought = 1.00;
		double moneyDanHasLeft = moneyDanHas - costOfCandyBought;

        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int numberOfBoats = 5;
		int numberOfPeopleInEachBoat = 3;
		int totalPeopleOnBoats = numberOfBoats * numberOfPeopleInEachBoat;
		
		
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int legosEllenHas = 380;
		int legosEllenLost = 57;
		int totalLegosEllenHasNow = legosEllenHas - legosEllenLost;
		
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int muffinsArthurBaked = 35;
		int totalMuffinsArthurNeeds = 83;
		int muffinsArthurNeedsToBake = totalMuffinsArthurNeeds - muffinsArthurBaked;

        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int crayonsWillyHas = 1400;
		int crayonsLucyHas = 290;
		int crayonsWillyLucyDifference = crayonsWillyHas - crayonsLucyHas;

		
		
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int numStickersOnPage = 10;
		int pagesOfStickers = 22;
		int totalStickers = numStickersOnPage * pagesOfStickers;
		
		
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		int totalCupcakes = 96;
		int totalChildren = 8;
		double cupcakesPerPerson = totalCupcakes/totalChildren;

        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		int gingerbreadCookiesMade = 47;
		int cookiesEachJarContain = 6;
		int cookiesNotInJars = 47%6;
		System.out.println(cookiesNotInJars);

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		int totalCroissants = 59;
		int croissantsEachNeighborReceive = 8;
		int croissantsLeft = 59%8;
		
		
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int numCookiesOnOneTray = 12;
		int totalCookies = 276;
		int totalTraysNeed = totalCookies/numCookiesOnOneTray;
		
		
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int totalPretzels = 480;
		int pretzelsPerServing = 12;
		int totalServings = totalPretzels/pretzelsPerServing;
		
		
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int totalLemonCupcakes = 53;
		int lemonCupcakesLeftAtHome = 2;
		int boxesWith3Cupcakes = (int)((totalLemonCupcakes - lemonCupcakesLeftAtHome)/3);
		System.out.println(boxesWith3Cupcakes);

		
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int totalCarrotSticks = 74;
		int totalPeople = 12;
		int carrotSticksLeft = totalCarrotSticks % totalPeople;

        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int totalTeddyBears = 98;
		int maxShelfCarryBears = 7;
		int shellsFilledBears = totalTeddyBears/maxShelfCarryBears;
		
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int totalPictures = 480;
		int picturesInAnAlbum = 20;
		int totalAlbumsNeeded = totalPictures/picturesInAnAlbum;
		

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int totalTradingCards = 98;
		int maxCardsBoxCanHold = 8;
		int totalBoxesFilled = totalTradingCards/maxCardsBoxCanHold;
		int cardsInUnfilledBox = totalTradingCards % maxCardsBoxCanHold;

        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int totalBooksRepaired = 210;
		int totalShelves = 10;
		int booksOnEachShelve = totalBooksRepaired/totalShelves;

        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		int totalCroissantsBaked = 17;
		int totalGuests = 7;
		int croissantsPerGuest = totalCroissantsBaked/totalGuests;

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */

        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */


	}

}
