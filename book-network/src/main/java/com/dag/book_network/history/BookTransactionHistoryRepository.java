package com.dag.book_network.history;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookTransactionHistoryRepository extends JpaRepository<BookTransactionHistory, Integer> {

    @Query(
            """
            SELECT history
            FROM BookTransactionHistory history
            WHERE history.user.id = :userId  \s
           \s"""
    )
    Page<BookTransactionHistory> findAllBorrowedBooks(Pageable pageable, Integer userId);


    @Query(
            """
            SELECT history
            FROM BookTransactionHistory history
            WHERE history.book.owner.id = :userId  \s
           \s"""
    )
    Page<BookTransactionHistory> findAllReturnedBooks(Pageable pageable, Integer userId);

    @Query(
            """
            SELECT
            (COUNT(*) > 0) AS isBorrowed
            FROM BookTransactionHistory bookTransactionHistory
            WHERE bookTransactionHistory.user.id = :userId
            AND bookTransactionHistory.book.id = :bookId
            AND bookTransactionHistory.returnApproved = false
                   \s"""
    )
    boolean isAlreadyBorrowedByUser(Integer bookId, Integer userId);

    @Query(
            """
            SELECT transaction
            FROM BookTransactionHistory transaction
            WHERE transaction.user.id = :userId
            AND transaction.book.id = :bookId
            AND transaction.returned = false
            AND transaction.returnApproved = false
                   \s"""
    )

    Optional<BookTransactionHistory> findByBookIdAndUserId(Integer bookId, Integer userId);

    @Query(
            """
            SELECT transaction
            FROM BookTransactionHistory transaction
            WHERE transaction.book.owner.id = :ownerId
            AND transaction.book.id = :bookId
            AND transaction.returned = true
            AND transaction.returnApproved = false
                   \s"""
    )
    Optional<BookTransactionHistory> findByBookIdAndOwnerId(Integer bookId, Integer ownerId);

}
