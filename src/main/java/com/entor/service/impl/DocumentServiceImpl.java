package com.entor.service.impl;

import com.entor.entity.Document;
import com.entor.mapper.DocumentMapper;
import com.entor.service.IDocumentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2019-10-14
 */
@Service
public class DocumentServiceImpl extends ServiceImpl<DocumentMapper, Document> implements IDocumentService {
	
}
