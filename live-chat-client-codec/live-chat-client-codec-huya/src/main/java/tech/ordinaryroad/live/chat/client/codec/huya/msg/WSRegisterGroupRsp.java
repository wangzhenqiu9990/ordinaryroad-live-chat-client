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

package tech.ordinaryroad.live.chat.client.codec.huya.msg;

import cn.hutool.core.collection.CollUtil;
import com.qq.tars.protocol.tars.TarsInputStream;
import com.qq.tars.protocol.tars.TarsOutputStream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.ordinaryroad.live.chat.client.codec.huya.constant.HuyaOperationEnum;
import tech.ordinaryroad.live.chat.client.codec.huya.msg.base.BaseHuyaMsg;

import java.util.List;

/**
 * @author mjz
 * @date 2023/10/5
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WSRegisterGroupRsp extends BaseHuyaMsg {

    private int iResCode;
    private List<String> vSupportP2PGroupId = CollUtil.newArrayList("");

    public WSRegisterGroupRsp(TarsInputStream is) {
        this.readFrom(is);
    }

    @Override
    public void writeTo(TarsOutputStream os) {
        os.write(this.iResCode, 0);
        os.write(this.vSupportP2PGroupId, 1);
    }

    @Override
    public void readFrom(TarsInputStream is) {
        this.iResCode = is.read(this.iResCode, 0, true);
        this.vSupportP2PGroupId = is.readArray(this.vSupportP2PGroupId, 1, true);
    }

    @Override
    public HuyaOperationEnum getOperationEnum() {
        return HuyaOperationEnum.EWSCmdS2C_RegisterGroupRsp;
    }
}
