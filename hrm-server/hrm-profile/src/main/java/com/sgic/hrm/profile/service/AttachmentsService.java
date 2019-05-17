package com.sgic.hrm.profile.service;

import java.util.List;
import com.sgic.hrm.commons.entity.Attachment;

public interface AttachmentsService {
  boolean addAttachments(Attachment attachments);

  List<Attachment> getAllAttachments();

  boolean editAttachments(Attachment attachments, Integer id);

  boolean deleteAttachments(Integer id);

  Attachment getById(Integer id);

}
