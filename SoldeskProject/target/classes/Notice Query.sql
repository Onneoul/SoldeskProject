select notice_title, notice_number, notice_category, notice_id
from notice
where notice_category = #{notice_category}



select notice_title, notice_text, notice_category
from notice
where notice_number = #{notice_number}


update notice_title, notice_text, notice_category
from notice
where notice_number = #{notice_number}



alter table notice add (notice_category NUMBER(2) default 1);