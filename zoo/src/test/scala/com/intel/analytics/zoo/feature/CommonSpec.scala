/*
 * Copyright 2018 Analytics Zoo Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intel.analytics.zoo.feature

import com.intel.analytics.zoo.feature.common.{BigDLAdapter, Preprocessing}
import com.intel.analytics.zoo.feature.image.Resize
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}


class CommonSpec extends FlatSpec with Matchers with BeforeAndAfter {

  "BigDLAdapter" should "adapt BigDL Transformer" in {
    val newResize = BigDLAdapter(Resize(1, 1))
    assert(newResize.isInstanceOf[Preprocessing[Any, Any]])
  }
}
