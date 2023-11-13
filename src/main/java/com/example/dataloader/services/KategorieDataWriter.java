package com.example.dataloader.services;

import com.example.dataloader.entities.Kategorie;
import com.example.dataloader.entities.KategorieHierarchie;
import com.example.dataloader.repositories.KategorieHierarchieRepository;
import com.example.dataloader.repositories.KategorieRepository;
import com.example.dataloader.xmlreader.categories_entities.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KategorieDataWriter {
    private final KategorieRepository kategorieRepository;
    private final KategorieHierarchieRepository kategorieHierarchieRepository;

    public void saveKategories(List<Category> categories){
        for(var category:categories) {
            var kategorie = Kategorie.builder()
                    .kategoriename(category.getName())
                    .build();
            var kategorie1 = kategorieRepository.save(kategorie);
            saveSubCategories(kategorie1.getId(), category.getSubCategories());
        }
    }

        public void saveSubCategories(Integer parentId, List<Category> subcategories){
        for( var subcategory : subcategories){
            var subkategorie = Kategorie.builder()
                    .kategoriename(subcategory.getName())
                    .build();
            var savedSubcategory= kategorieRepository.save(subkategorie);
           var relation = KategorieHierarchie.builder()
                   .elternid(parentId)
                   .kinderid(savedSubcategory.getId())
                   .build();
           kategorieHierarchieRepository.save(relation);

           if(subcategory.getSubCategories()!=null && subcategory.getSubCategories().size()>0){
               saveSubCategories(savedSubcategory.getId(),subcategory.getSubCategories());
           }

        }
        }
    public void saveCategoryHierarhie (Category category){
//        var kategorieHierarhie = KategorieHierarchie.builder()
//                .kinderid(category.getSubCategories()
//                        .stream().
//                        map(category1 -> category1.getName()).)
//                .build();
    }
}
