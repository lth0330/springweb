package practice.practice5;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // 도서 전체 조회
    public List<BookDto> 도서전체조회() {
        List<BookEntity> bookEntityList = bookRepository.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();

        bookEntityList.forEach(entity -> {
            BookDto bookDto = new BookDto();
            bookDto.setBno(entity.getBno());
            bookDto.setBid(entity.getBid());
            bookDto.setBname(entity.getBname());
            bookDto.setBwriter(entity.getBwriter());
            bookDto.setBpublisher(entity.getBpublisher());
            bookDtoList.add(bookDto);
        });
        return bookDtoList;

    }

    // 도서 등록
    public boolean 도서등록(BookDto bookDto) {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setBid(bookDto.getBid());
        bookEntity.setBname(bookDto.getBname());
        bookEntity.setBwriter(bookDto.getBwriter());
        bookEntity.setBpublisher(bookDto.getBpublisher());
        BookEntity saveEntity = bookRepository.save(bookEntity);

        if (saveEntity.getBno() >= 1)return true;
        return false;
    }

    //  도서 삭제
    public boolean 도서삭제(int bno){

        bookRepository.deleteById(bno);
        return true;
    }

    // 도서 수정
    @Transactional
    public boolean 도서수정(BookDto bookDto){
        Optional <BookEntity> optional = bookRepository.findById(bookDto.getBno());

        if (optional.isPresent()){
            BookEntity bookEntity = optional.get();
            bookEntity.setBid(bookDto.getBid());
            bookEntity.setBname(bookDto.getBname());
            bookEntity.setBwriter(bookDto.getBwriter());
            bookEntity.setBpublisher(bookEntity.getBpublisher());
            return true;

        }
        return false;
    }
}