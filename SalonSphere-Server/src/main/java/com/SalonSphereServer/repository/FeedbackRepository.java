package com.SalonSphereServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SalonSphereServer.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

    // Through this method we find all the feedbacks of a certain salon
    List<Feedback> findByShopIdOrderByReviewDateDesc(String shopId);

    // Custom query method to fetch likes based on review_id
    @Query("SELECT f.likes FROM Feedback f WHERE f.reviewId = :reviewId")
    Integer findLikesByReviewId(int reviewId);

    // Custom query method to update likes based on review ID
    @Transactional
    @Modifying
    @Query("UPDATE Feedback f SET f.likes = :likes WHERE f.reviewId = :reviewId")
    void updateLikesByReviewId(int likes, int reviewId);

    // Custom query to calculate the average rating for a specific shop ID
    @Query(value = "SELECT AVG(f.rating) FROM Feedback f WHERE f.shopId = :shopId")
    Double getAverageRatingByShopId(String shopId);

}
