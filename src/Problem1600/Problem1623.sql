SELECT
    a.student_name  as member_A,
    b.student_name  as member_B,
    c.student_name  as member_C
FROM SchoolA a
LEFT JOIN SchoolB b ON a.student_id != b.student_id AND a.student_name != b.student_name
LEFT JOIN SchoolC c ON a.student_id != c.student_id AND a.student_name != c.student_name AND b.student_id != c.student_id AND b.student_name != c.student_name
WHERE
    b.student_id IS NOT NULL AND c.student_id IS NOT NULL
