package com.example.testsPostgres.repository;

import com.example.testsPostgres.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Query(value = """
            SELECT public.student_answer.user_id, public.student_answer.test_id,\s
            public.answer.question_id, public.answer.text, public.answer.correct\s
            FROM public.answer
            JOIN public.student_answer ON public.answer.row_id = public.student_answer.answer_id
            WHERE public.answer.row_id in (select answer_id from public.student_answer where user_id=:userID)""",
            nativeQuery=true)
    List<Object[]> findAllByUserID(Long userID);
}
