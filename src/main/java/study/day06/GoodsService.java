package study.day06;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Transactional
@Service
public class GoodsService {


    @Autowired
    private GoodsRepository goodsRepository;


    public boolean 저장(GoodsDto goodsDto){


    }

    public boolean 수정(GoodsDto goodsDto){

    }
}
