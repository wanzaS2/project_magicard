package com.magic4.magicard.service_sy;

import org.springframework.stereotype.Service;

import com.magic4.magicard.repository_sy.RequestRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequestService {
  final RequestRepo requestRepo;
}
