/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.lib.service;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.fs.http.client.HttpFSKerberosAuthenticator;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.security.token.delegation.AbstractDelegationTokenIdentifier;

/**
 * HttpFS <code>DelegationTokenIdentifier</code> implementation.
 */
@InterfaceAudience.Private
public class DelegationTokenIdentifier
  extends AbstractDelegationTokenIdentifier {

  public static final Text KIND_NAME =
    new Text(HttpFSKerberosAuthenticator.TOKEN_KIND);

  public DelegationTokenIdentifier() {
  }

  /**
   * Create a new delegation token identifier
   *
   * @param owner the effective username of the token owner
   * @param renewer the username of the renewer
   * @param realUser the real username of the token owner
   */
  public DelegationTokenIdentifier(Text owner, Text renewer, Text realUser) {
    super(owner, renewer, realUser);
  }


  /**
   * Returns the kind, <code>TOKEN_KIND</code>.
   * @return returns <code>TOKEN_KIND</code>.
   */
  @Override
  public Text getKind() {
    return KIND_NAME;
  }

}
