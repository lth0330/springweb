package study.day06;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.util.Optional;

@Transactional
@Service
public class GoodsService {


    @Autowired
    private GoodsRepository goodsRepository;


    public boolean 저장(GoodsDto goodsDto){
        // 1] dto --> entity 변환
        GoodsEntity goodsEntity = goodsDto.toEntitiy();

        // 2] JPA save 이용하여 엔티티 insert 하기
        GoodsEntity saved = goodsRepository.save(goodsEntity);

        //*********************
        // 또는 1,2번을 합친
        // GoodsEntity saved = goodsRepository.save(goodsDto.toEntitiy());
        //*********************

        // 3] save 결과에 pk여부 성공판단
        if (saved.getGno()>=1) return  true;
        return false;

    }

    public boolean 수정(GoodsDto goodsDto){

        // 1] 수정할 앤티티의 pk 번호 확인
        int updatePk = goodsDto.getGno();

        // 2] 수정할 앤티티 찾기 --> 영속성
        Optional<GoodsEntity> optional = goodsRepository.findById(updatePk);

        // 3] 만약에 찾은 앤티티가 존재하면
        if(optional.isPresent()){
            GoodsEntity updateEntity = optional.get();
            updateEntity.setGdesc(goodsDto.getGdesc());
            updateEntity.setGprice(goodsDto.getGprice());
            updateEntity.setGname(goodsDto.getGname());
           return true;

        }else {return false;}
    }
}
