// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: email_service.proto

package com.example.email;

public interface EmailResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:email.EmailResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool success = 1;</code>
   * @return The success.
   */
  boolean getSuccess();

  /**
   * <code>string message = 2;</code>
   * @return The message.
   */
  java.lang.String getMessage();
  /**
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>string from = 3;</code>
   * @return The from.
   */
  java.lang.String getFrom();
  /**
   * <code>string from = 3;</code>
   * @return The bytes for from.
   */
  com.google.protobuf.ByteString
      getFromBytes();

  /**
   * <code>string subject = 4;</code>
   * @return The subject.
   */
  java.lang.String getSubject();
  /**
   * <code>string subject = 4;</code>
   * @return The bytes for subject.
   */
  com.google.protobuf.ByteString
      getSubjectBytes();

  /**
   * <code>string body = 5;</code>
   * @return The body.
   */
  java.lang.String getBody();
  /**
   * <code>string body = 5;</code>
   * @return The bytes for body.
   */
  com.google.protobuf.ByteString
      getBodyBytes();
}