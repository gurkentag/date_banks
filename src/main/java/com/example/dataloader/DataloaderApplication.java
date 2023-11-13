		package com.example.dataloader;
		import com.example.dataloader.bootstrapData.BootstrapData;
		import com.example.dataloader.services.KategorieDataWriter;
		import com.example.dataloader.services.KategorieReader;
		import com.example.dataloader.services.ShopDataWriter;
		import com.example.dataloader.xmlreader.MyXmlReader;
		import com.example.dataloader.xmlreader.categories_entities.Categories;
		import com.example.dataloader.xmlreader.xml_entities.Shop;
		import lombok.RequiredArgsConstructor;
		import org.springframework.boot.CommandLineRunner;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;

		import java.io.IOException;
		import java.io.InputStream;
		import java.util.Scanner;


		@SpringBootApplication
		@RequiredArgsConstructor
		public class DataloaderApplication implements CommandLineRunner {


	//		private final KategorieReader kategorieReader;
			private final BootstrapData bootstrapData;
			private final MyXmlReader myXmlReader;
			private final ShopDataWriter shopDataWriter;
			private final KategorieDataWriter kategorieDataWriter;

			public static void main(String[] args) {
				SpringApplication.run(DataloaderApplication.class, args);
			}

			@Override
			public void run(String... args) throws Exception {

				String categoriesFileName = "data/categories.xml";
				var categoriesXmlString = readResourceFileAsString(categoriesFileName);
				Categories categories = myXmlReader.parseCategories(categoriesXmlString);
//				kategorieDataWriter.saveKategories(categories.getCategories());

	//			 read resource  leipzig file as string
				String leipzigFileName = "data/leipzig_transformed.xml";
				var leipzigXmlString = readResourceFileAsString(leipzigFileName);
				 Shop leipzigShop = myXmlReader.parse(leipzigXmlString);
				 shopDataWriter.saveShopData(leipzigShop, categories);

				// read resource  dresden file as string
				String dresdenFileName = "data/dresden.xml";
				var dresdenXmlString = readResourceFileAsString(dresdenFileName);
				Shop dresdenShop =myXmlReader.parse(dresdenXmlString);
				shopDataWriter.saveShopData(dresdenShop, categories);

				//read and save kunden and bewertungen
//				bootstrapData.speichereGeleseneFile();
			}

			//function to read files from resources folder
			private String readResourceFileAsString(String fileName) throws IOException {
				StringBuilder contentBuilder = new StringBuilder();

				ClassLoader classLoader = DataloaderApplication.class.getClassLoader();

				// Get the input stream for the resource file
				InputStream inputStream = classLoader.getResourceAsStream(fileName);

				if (inputStream != null) {
					try (Scanner scanner = new Scanner(inputStream)) {
						while (scanner.hasNextLine()) {
							contentBuilder.append(scanner.nextLine()).append("\n");
						}
					}
				} else {
					throw new IOException("Resource file not found: " + fileName);
				}

				return contentBuilder.toString();
			}
		}