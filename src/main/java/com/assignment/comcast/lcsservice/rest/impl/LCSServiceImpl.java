package com.assignment.comcast.lcsservice.rest.impl;

import com.assignment.comcast.lcsservice.dto.LCSRequest;
import com.assignment.comcast.lcsservice.dto.LCSResponse;
import com.assignment.comcast.lcsservice.dto.SetOfString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LCSServiceImpl {

@Autowired
private LCSResponse lcsResponse;

    public LCSResponse getLCSSubstring(LCSRequest request) {

        if(null != request)
        {
            List<SetOfString> setOfStringList = request.getSetOfStrings();
            String[] lcsreq = new String[setOfStringList.size()];

            for(int i=0;i<setOfStringList.size();i++)
            {
                SetOfString s = setOfStringList.get(i);
                String val = s.getValue();
                System.out.println("val"+val);
                lcsreq[i] = val;
            }

            List<SetOfString> lcsStr = new ArrayList<>();

            String result = findLCSWord(lcsreq);

            SetOfString setOfString = new SetOfString();
            setOfString.setValue(result);
            lcsStr.add(setOfString);

            lcsResponse.setLcs(lcsStr);

            return lcsResponse;
        }
        return lcsResponse;
    }

    private String findLCSWord(String[] arr)
    {
        // size of the array
        int arrLen = arr.length;

        // Reference -  first word from array
        String str = arr[0];
        int len = str.length();

        String result = "";

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {

                // From reference string arr[0] generate possible all substrings
                String chunk = str.substring(i, j);
                int k = 1;
                for (k = 1; k < arrLen; k++)

                    // Check if the chunk is similar to other words
                    if (!arr[k].contains(chunk))
                        break;

                // If current substring is present in
                // all strings and its length is greater
                // than current result
                if (k == arrLen && result.length() < chunk.length())
                    result = chunk;
            }
        }

        return result;
    }


}
