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

package com.intel.analytics.zoo.pipeline.api.keras.layers

import com.intel.analytics.bigdl.{nn => bnn}
import com.intel.analytics.bigdl.nn.abstractnn.{AbstractModule, Activity, DataFormat}
import com.intel.analytics.bigdl.tensor.Tensor
import com.intel.analytics.bigdl.tensor.TensorNumericMath.TensorNumeric
import com.intel.analytics.bigdl.utils.Shape
import com.intel.analytics.zoo.pipeline.api.Net
import com.intel.analytics.zoo.pipeline.api.keras.layers.utils.KerasUtils

import scala.reflect.ClassTag

class ResizeBilinear[T: ClassTag](
  val outputHeight: Int,
  val outputWidth: Int,
  val alignCorners: Boolean,
  val dataFormat: DataFormat = DataFormat.NCHW)(implicit ev: TensorNumeric[T])
  extends LayerWrapperByForward[T] {

  override def doBuild(inputShape: Shape): AbstractModule[Activity, Activity, T] = {
    bnn.ResizeBilinear[T](outputHeight, outputWidth, alignCorners, dataFormat)
  }
}

object ResizeBilinear {

  def apply[T: ClassTag](outputHeight: Int, outputWidth: Int, alignCorners: Boolean = false,
                         dataFormat: DataFormat = DataFormat.NCHW)
    (implicit ev: TensorNumeric[T]): ResizeBilinear[T] = {
    new ResizeBilinear[T](outputHeight, outputWidth, alignCorners, dataFormat)
  }
}
