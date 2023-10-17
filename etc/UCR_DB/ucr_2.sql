create or replace PROCEDURE increase_view_count(
    p_notice_no IN NUMBER
)
IS old_view_count NUMBER;
BEGIN
    SELECT view_count INTO old_view_count FROM notice WHERE notice_no = p_notice_no;

    UPDATE notice
    SET view_count = old_view_count+1
    WHERE notice_no = p_notice_no;
    COMMIT;
END increase_view_count;