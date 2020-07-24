// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.search.robotstxt;

/**
 * The interface provides parsing logic for {@link Parser} class. Its implementation is expected to
 * accumulate parsed robots.txt lines and be able to compute {@link RobotsMatcher} instance as soon
 * as all robots.txt lines were inputted.
 */
public interface ParseHandler {
  /**
   * Handler for the beginning of parsing process.
   */
  void handleStart();

  /**
   * Handler for the end of parsing process.
   */
  void handleEnd();

  /**
   * Directive receiver. Each directive consists of type and value.
   *
   * @param directiveType type of received directive
   * @param directiveValue value of received directive
   */
  void handleDirective(final Parser.DirectiveType directiveType, final String directiveValue);

  /**
   * Method to finalize all received via
   * {@link this#handleDirective(Parser.DirectiveType, String)} data and produces an matcher
   * based on it. Thus, it returns serialized view of robots.txt file with matching functionality.
   *
   * @return matcher representing original robots.txt file
   */
  Matcher compute();
}
