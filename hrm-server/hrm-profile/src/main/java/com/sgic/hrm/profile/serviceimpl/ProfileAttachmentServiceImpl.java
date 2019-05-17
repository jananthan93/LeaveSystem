package com.sgic.hrm.profile.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.ProfileAttachments;
import com.sgic.hrm.commons.repository.ProfileAttachmentRepository;
import com.sgic.hrm.profile.service.ProfileAttachmentService;

@Service
public class ProfileAttachmentServiceImpl implements ProfileAttachmentService {

  @Autowired
  private ProfileAttachmentRepository profileAttachmentRepository;

  @Override
  public boolean addAttachment(ProfileAttachments profileAttachments) {
    profileAttachmentRepository.save(profileAttachments);
    return true;
  }

  @Override
  public List<ProfileAttachments> getAttachments() {
    return profileAttachmentRepository.findAll();
  }
}
