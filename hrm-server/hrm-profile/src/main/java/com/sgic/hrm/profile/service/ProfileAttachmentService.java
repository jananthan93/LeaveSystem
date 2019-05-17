package com.sgic.hrm.profile.service;

import java.util.List;
import com.sgic.hrm.commons.entity.ProfileAttachments;



public interface ProfileAttachmentService {
  boolean addAttachment(ProfileAttachments profileAttachments);

  List<ProfileAttachments> getAttachments();
}
