/*
 * MIT License
 *
 * Copyright (c) 2023 OrdinaryRoad
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin.proto

// Protobuf Java Version: 3.25.3
package tech.ordinaryroad.live.chat.client.codec.douyin.protobuf;

public interface FansClubOrBuilder extends
    // @@protoc_insertion_point(interface_extends:FansClub)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.FansClubData data = 1;</code>
   * @return Whether the data field is set.
   */
  boolean hasData();
  /**
   * <code>.FansClubData data = 1;</code>
   * @return The data.
   */
  tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.FansClubData getData();
  /**
   * <code>.FansClubData data = 1;</code>
   */
  tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.FansClubDataOrBuilder getDataOrBuilder();

  /**
   * <code>map&lt;int32, .FansClubData&gt; preferData = 2;</code>
   */
  int getPreferDataCount();
  /**
   * <code>map&lt;int32, .FansClubData&gt; preferData = 2;</code>
   */
  boolean containsPreferData(
      int key);
  /**
   * Use {@link #getPreferDataMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.Integer, tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.FansClubData>
  getPreferData();
  /**
   * <code>map&lt;int32, .FansClubData&gt; preferData = 2;</code>
   */
  java.util.Map<java.lang.Integer, tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.FansClubData>
  getPreferDataMap();
  /**
   * <code>map&lt;int32, .FansClubData&gt; preferData = 2;</code>
   */
  /* nullable */
tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.FansClubData getPreferDataOrDefault(
      int key,
      /* nullable */
tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.FansClubData defaultValue);
  /**
   * <code>map&lt;int32, .FansClubData&gt; preferData = 2;</code>
   */
  tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.FansClubData getPreferDataOrThrow(
      int key);
}
