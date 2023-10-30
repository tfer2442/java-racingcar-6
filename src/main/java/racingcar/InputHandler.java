package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.Constants.*;

public class InputHandler {
    public static List<String> carNames() {
        String carNamesWithSeparator = Console.readLine();
        String[] tokens = StringManipulator.splitSeparator(carNamesWithSeparator, SEPARATOR);
        checkValidCarNames(tokens);
        List<String> carNamesWithoutSeparator = StringManipulator.toList(tokens);
        return carNamesWithoutSeparator;
    }

    public static int tryNumber() {
        String trialNum = Console.readLine();
        checkValidTryNumber(trialNum);
        return Integer.parseInt(trialNum);
    }

    private static void checkValidCarNames(String[] carNameGroup) {
        if (!StringManipulator.isValidLength(carNameGroup)) {
            throw new IllegalArgumentException("자동차 이름의 길이는 " + MIN_CAR_NAME_LEN + "이상, " + MAX_CAR_NAME_LEN + "이하여야 합니다.");
        }

        if (StringManipulator.hasDuplicates(carNameGroup)) {
            throw new IllegalArgumentException("중복된 이름을 입력하였습니다.");
        }

        if (!StringManipulator.isValidNames(carNameGroup)) {
            throw new IllegalArgumentException("차 이름은 숫자, _, 영어, 한글만 입력 가능합니다.");
        }
    }

    private static void checkValidTryNumber(String trialNum) {
        if (!trialNum.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("시도 횟수는 1이상의 숫자만 입력해야 합니다.");
        }
    }
}
