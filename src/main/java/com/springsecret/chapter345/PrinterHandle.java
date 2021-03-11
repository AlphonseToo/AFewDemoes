package com.springsecret.chapter345;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * PrinterHandle
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/5 11:12
 **/
@Component
public class PrinterHandle {

    @Setter
    @Autowired
    private List<Printer> printerList;

    void printChain() {
        for (Printer printer : printerList) {
            if (printer instanceof  StringPrinter) {
                printer.print("这是一个字符串。");
            } else if (printer instanceof  IntegerPrinter) {
                printer.print(100);
            } else if (printer instanceof  DoublePrinter) {
                printer.print(100.001);
            }
        }
    }
}
