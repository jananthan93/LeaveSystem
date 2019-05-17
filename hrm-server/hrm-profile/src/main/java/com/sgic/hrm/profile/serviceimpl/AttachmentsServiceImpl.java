package com.sgic.hrm.profile.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.Attachment;
import com.sgic.hrm.commons.repository.AttachmentsRepository;
import com.sgic.hrm.profile.service.AttachmentsService;

@Service
public class AttachmentsServiceImpl implements AttachmentsService {
  @Autowired
  AttachmentsRepository attachmentsRepository;

  @Override
  public boolean addAttachments(Attachment attachments) {
    attachmentsRepository.save(attachments);
    return true;
  }

  @Override
  public List<Attachment> getAllAttachments() {

    return attachmentsRepository.findAll();
  }

  @Override
  public boolean editAttachments(Attachment attachment, Integer id) {
    if (attachmentsRepository.getOne(id) != null) {
      attachment.setId(id);
      attachmentsRepository.save(attachment);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteAttachments(Integer id) {
    attachmentsRepository.deleteById(id);
    return true;
  }

  @Override
  public Attachment getById(Integer id) {
    return attachmentsRepository.findById(id).orElse(null);
  }

}
